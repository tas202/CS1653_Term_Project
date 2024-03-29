
import javax.crypto.SecretKey;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.*;
import java.util.regex.Pattern;


/* client application  to connect  with group server  */
@SuppressWarnings("ALL")
public class ClientApplication {

	private static String gs_server_name;
	private static int gs_port;

	private static GroupClient groupClient;
	/**
	 *
	 */
	private static FileClient fileClient;
	static UserToken token;
	static String username;
	private static PrivateKey clientSigPK;
	private static PublicKey  clientPubKey;
	private static PublicKey groupServerPublicKeyVir;
	private static PublicKey fileServerPublicKeyVir;

	private static String gsPubKeyFile = "rsaPublicKeyVir.bin";
	private static String fsPubKeyFile = "FS_rsaPublic.bin";

	private static Scanner scanner = new Scanner(System.in);

	public static void main (String []args){


			// if(args.length != 2) {
			// 	System.out.println("Usage: java -cp '.;bcprov' <user_private_key> <user_public_key>");
			// 	System.exit(0);
			// }
			// clientSigPK = getClientPrivateKey(args[0]);
			// clientPubKey = getPublicKey(args[1]);
			groupServerPublicKeyVir = getPublicKey(gsPubKeyFile);



		groupClient = new GroupClient();
		fileClient = new FileClient();
		boolean signedIn = false;
    while (true){
//      Scanner scanner = new Scanner(System.in);

			if(!signedIn){
				System.out.print("Username: ");
				username = scanner.nextLine();
				signedIn = true;
				try{
					clientSigPK = getClientPrivateKey(username + "_Private.bin");
					clientPubKey = getPublicKey(username + "_Public.bin");
				}catch(Exception e){ e.printStackTrace(); }
			}

			System.out.println("\n********** MAIN MENU **********");
			System.out.println("1) Connect to Group Server \n2) Connect to File Server \n3) Exit Program");
            String input = scanner.nextLine();
          	if (!input.matches("[0-9]")){
              System.out.println("Invalid input");
						}
            else if (input.equals("1")) connectToGroupServer(username);
            else if (input.equals("2")) connectToFileServer(username);
            else if (input.equals("3")) break;
        }
    }

	private static PublicKey getPublicKey(String pkBin) {
		PublicKey pk = null;
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(pkBin);
			ObjectInputStream is = new ObjectInputStream(fis);
			pk = (PublicKey) is.readObject();
		}catch (Exception e){
			System.out.println("Couldn't open " + pkBin + " or invalid key object");
		}
		return pk;
	}

	private static PrivateKey getClientPrivateKey(String pbKeyBin) throws IOException, ClassNotFoundException {
		PrivateKey pk = null;
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(pbKeyBin);
			ObjectInputStream is = new ObjectInputStream(fis);
			pk = (PrivateKey) is.readObject();
		}catch (Exception e){
			System.out.println("Couldn't open " + pbKeyBin + " or invalid private key object");
		}
		return pk;
	}

	private static void connectToFileServer(String username) {
//		Scanner scanner = new Scanner(System.in);
	 	System.out.print("Enter GROUP server address: ");
	 	gs_server_name = scanner.nextLine();
	 	System.out.print("Enter GROUP server port number: ");
	 	gs_port = scanner.nextInt();
	 	System.out.print("Enter password: ");
	 	scanner.nextLine();
	 	String pw = scanner.nextLine();

		System.out.println("");

		System.out.print("Enter FILE server address: ");
		String fs_server_name = scanner.nextLine();
		System.out.print("Enter FILE server port number: ");
		int fs_port = scanner.nextInt();
		// add fs public key to the token
		PublicKey fsPk = getPublicKey(fs_port + "FS_rsaPublic.bin");

	 	if (!groupClient.connect(gs_server_name, gs_port,
				clientSigPK,groupServerPublicKeyVir, username)) {
			System.out.println("Error connecting.");
			return;
		}

	 	//verify password
	 	if(!groupClient.verifyPassword(username, pw)){
		 	System.out.println("Incorrect username or password -- Cannot connect to Group Server.");
		 	return;
	 	}
    	token = groupClient.getToken(username,fsPk); //update token

		//======================= t6 ===================
//		userGroupsKeys = groupClient.getUserGroupsKeys(token);
//		if (userGroupsKeys != null) {
//			System.err.println("DBG checking group keys");
//			for (String gName : userGroupsKeys.keySet()) {
//				System.err.println("Group name  " + gName);
//				for (SecretKey secretKey : userGroupsKeys.get(gName)){
//					System.out.println(Base64.getEncoder().encodeToString(secretKey.getEncoded()));
//				}
//			}
//		}
//
//		System.out.println("DBG ClientAplication line 147: remove it later. I create userGroupsKeys " +
//				"list <String group name , list<SecretKeys>> which contains all" +
//				"group keys. we will always use the last key to encrypt. for decryption we have to get the key index first." +
//				"I'm not sure how userGroupsKeys is accurate, but all the codes I wrote surrounded by T6 tag like this " +
//				"========== T6 ================= we can review it");
		//===============================================

		groupClient.disconnect();


		fileServerPublicKeyVir  = getPublicKey(fs_port + fsPubKeyFile);

    fileClient = new FileClient(groupClient.keychain);
  	if(!fileClient.connect(fs_server_name, fs_port, clientSigPK,
		clientPubKey, fileServerPublicKeyVir)){
			//if this returns false the fs can't be trusted
			fileClient.disconnect();
			return;
  	}

    //if (fileClient.isConnected()) System.out.println("--Secure session with FS " + fs_port + " established--");


		while(true){ // while you are in file server
						System.out.println("\n********** FILE SERVER OPERATIONS **********");
            	System.out.println("1) List files\n" +
						"2) Upload\n" +
						"3) Download\n" +
						"4) Delete\n" +
						"5) Log out");
                String input = scanner.next();

				if (input.equals("1")) { // list files
					if (fileClient.listFiles(token) == null){
						fileClient.disconnect();
						return;
					}
					System.out.println("\nStored Files: " + fileClient.listFiles(token));
				}

				if (input.equals("2")) { // upload
					String source;
					String dest;
					String group;

					System.out.print("Which file do you want to upload: ");
					scanner.nextLine();
					source = scanner.nextLine();
					System.out.print("Save file on server as: ");
					dest = scanner.nextLine();
					System.out.print("Groupname: ");
					group = scanner.nextLine();

					System.out.println("");
					if(fileClient.upload(source, dest, group, token) == false){
						fileClient.disconnect();
						return;
					}

				}

				if (input.equals("3")) { // Download a file
					String source;
					String dest;

					System.out.print("Which file do you want to download: ");
					scanner.nextLine();
					source = scanner.nextLine();
					System.out.print("Save as: ");
					dest = scanner.nextLine();

					System.out.println("");
					if(fileClient.download(source, dest, token) == false){
						fileClient.disconnect();
						return;
					}

				}

				if (input.equals("4")) { // Delete a file
					String filename;

					System.out.print("Which file do you want to delete: ");
					scanner.nextLine();
					filename = scanner.nextLine();

					if(fileClient.delete(filename, token) == false){
						fileClient.disconnect();
						return;
					}

				}

        if(input.equals("5")) {
          System.out.println("Logging out.");
          fileClient.disconnect();
          return;
        }

        if (!input.matches("[1-5]")) System.out.println("Invalid input.");

    }
}

	// handle all group server operations
     private static void connectToGroupServer(String username) {

//		 Scanner scanner = new Scanner(System.in);
		 System.out.print("Enter GROUP server address: ");
		 gs_server_name = scanner.nextLine();
		 System.out.print("Enter GROUP server port number: ");
		 gs_port = Integer.parseInt(scanner.nextLine());
		 System.out.print("Enter password: ");
//		 scanner.nextLine();
		 String pw = scanner.nextLine();

		 if (!groupClient.connect(gs_server_name, gs_port,
				clientSigPK,groupServerPublicKeyVir, username)) {
			System.out.println("Error connecting.");
			return;
		}

		 //verify password
		 if(!groupClient.verifyPassword(username, pw)){
			 System.out.println("Incorrect username or password -- Cannot connect to Group Server.");
			 return;
		 }

		 token = groupClient.getToken(username,null); //update token
		 if(token != null) groupServerMenu();
		 else System.out.println("Couldn't verify your user name");
		 }

     // return true if the use in the admin group
    private static boolean isUserInAdminGroup(List<String> groups) {
        try {
        for(String s : groups){
            if (s.equals("ADMIN")) return true;
        }
        return false;
        }catch (Exception Ignore){ return false;}
    }

    private static void groupServerMenu() {
//        Scanner scanner = new Scanner(System.in);
        while (true) {


        	token = groupClient.getToken(token.getSubject(),null); //update token


			System.out.println("\n********** GROUP SERVER OPERATIONS **********");
            System.out.println("1) Create a user \n2) Delete a user\n3) Create a group " +
                    "\n4) Delete a group \n5) List group members \n6) Add User to group \n7) Remove user from group \n8) Logout");
            String input = scanner.next();
            if (!Pattern.matches("[0-9]", input)) System.out.println("Invalid input");
            else if (input.equals("1")) createUserInGS();
            else if (input.equals("2")) delUserFromGS();
            else if (input.equals("3")) createGroupInGS();
            else if (input.equals("4")) delGroupInGS();
            else if (input.equals("5")) listMembersGroup();
						else if (input.equals("6")) addUserToGroup();
						else if (input.equals("7")) delUserFromGroup();
            else if (input.equals("8")) {
                System.out.println("Logging out.");
                groupClient.disconnect();
                return;
            }
        }
    }

    private static void listMembersGroup() {
			try {
					System.out.println(".......... List Group Members ..........");
					System.out.print("Enter a group name: ");
//					Scanner scanner = new Scanner(System.in);
					String groupName = scanner.next();
					List<String> members = groupClient.listMembers(groupName, token);
					if (members != null) {
						System.out.print("Members of " + groupName + ": \n");
							for (String s : members) {
									System.out.println("  " + s);
							}
					}
					else
							System.out.println("No a such group exist or check permissions");
			}catch (Exception Ignore){
					System.out.println("No a such group exist or check permissions");
			}
    }

    private static void delGroupInGS() {
//        Scanner scanner = new Scanner(System.in);
        System.out.println(".......... Delete Group ..........");
        System.out.print("Enter a group name to delete: ");
        String groupName = scanner.next();

        if (groupClient.deleteGroup(groupName,token)){
            System.out.println("Group " + groupName + " deleted successfully.");
						// refresh the server
						groupClient.disconnect();
            groupClient.connect(gs_server_name, gs_port,clientSigPK, groupServerPublicKeyVir, token.getSubject());
        }
        else System.out.println("Error deleting a group.");

    }

    private static void createGroupInGS() {
//        Scanner scanner = new Scanner(System.in);
        System.out.println(".......... Create Group ..........");
        System.out.print("Enter a group name to create: ");

        String groupName = scanner.next();
        if (groupClient.createGroup(groupName,token)){
            System.out.println("Group " + groupName + " created successfully.");
						// refresh the server
            groupClient.disconnect();
			groupClient.connect(gs_server_name, gs_port,clientSigPK, groupServerPublicKeyVir, token.getSubject());
        }
        else System.out.println("Error creating a group.");

		}

    private static void delUserFromGS() {
//        Scanner scanner = new Scanner(System.in);
        System.out.println(".......... Delete User ..........");
        System.out.print("Enter a username to delete: ");
        String username = scanner.next();
        if (groupClient.deleteUser(username,token)){
            System.out.println("User " + username + " deleted successfully.");
						// refresh the server
            groupClient.disconnect();
			groupClient.connect(gs_server_name, gs_port,clientSigPK, groupServerPublicKeyVir, token.getSubject());
				}
        else System.out.println("Error deleting a user.");

    }

    private static void createUserInGS() {
//         Scanner scanner = new Scanner(System.in);
         System.out.println(".......... Create New User ..........");
         System.out.print("Enter a new username: ");
         String username = scanner.next();
         if (groupClient.createUser(username,token)){
             System.out.println("User " + username + " created successfully.");
             // refresh the server
             groupClient.disconnect();
			 groupClient.connect(gs_server_name, gs_port,clientSigPK, groupServerPublicKeyVir, token.getSubject());
         }
         else System.out.println("Error creating a user.");
     }

		 private static void addUserToGroup() {
			 try {
				 System.out.println(".......... Add User to Group ..........");
				 System.out.print("Enter a group name: ");
//				 Scanner scanner = new Scanner(System.in);
				 String groupName = scanner.next();
				 System.out.print("Enter a user to be added to a group " + groupName + ": ");
				 String userToBeAdd = scanner.next();
				 if(groupClient.addUserToGroup(userToBeAdd,groupName,token)){
						 System.out.println("User " + userToBeAdd + " added to group " + groupName + " successfully.");
						 // refresh the server
						 groupClient.disconnect();
					 groupClient.connect(gs_server_name, gs_port,clientSigPK, groupServerPublicKeyVir, token.getSubject());
				 }
				 else
						 System.out.println("Error adding user to a group.");

			 }catch (Exception Ignore){
					 System.out.println("Error adding user to a group.");
			 }
      }

			private static void delUserFromGroup() {
	        try {
	            System.out.println(".......... Delete User From Group ..........");
	            System.out.print("Enter a group name: ");
//	            Scanner scanner = new Scanner(System.in);
	            String groupName = scanner.next();
	            System.out.print("Enter a user to be deleted from group " + groupName + ": ");
	            String userToBeDel = scanner.next();
	            if(groupClient.deleteUserFromGroup(userToBeDel,groupName,token)){
	                System.out.println("User " + userToBeDel + " deleted from group " + groupName + " successfully.");
	                // refresh the server
	                groupClient.disconnect();
					groupClient.connect(gs_server_name, gs_port,clientSigPK, groupServerPublicKeyVir, token.getSubject());
	            }
	            else
	                System.out.println("Error deleting  user from group" + groupName + ".");

	        }catch (Exception Ignore){
	            System.out.println("Error adding user to a group.");
	        }
	    }



 }
