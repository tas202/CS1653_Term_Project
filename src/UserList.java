/* This list represents the users on the server */

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;


public class UserList implements java.io.Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 7600343803563417992L;
    private Hashtable<String, User> list = new Hashtable<String, User>();

    public synchronized User getUser(String username){
        return list.get(username);
    }

    public synchronized void addUser(String username, String hashedPassword)
    {
        User newUser = new User();
        newUser.setPwHash(hashedPassword);
        list.put(username, newUser);

    }

    public synchronized void deleteUser(String username)
    {
        list.remove(username);
    }

    public synchronized boolean checkUser(String username)
    {
        if(list.containsKey(username))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public synchronized ArrayList<String> getUserGroups(String username)
    {
        return list.get(username).getGroups();
    }

    public synchronized ArrayList<String> getUserOwnership(String username)
    {
        return list.get(username).getOwnership();
    }

    public synchronized void addGroup(String user, String groupname)
    {
        list.get(user).addGroup(groupname);
    }

    public synchronized void removeGroup(String user, String groupname)
    {
        list.get(user).removeGroup(groupname);
    }

    public synchronized void addOwnership(String user, String groupname)
    {
        list.get(user).addOwnership(groupname);
    }

    public synchronized void removeOwnership(String user, String groupname)
    {
        list.get(user).removeOwnership(groupname);
    }

public synchronized List<String> getAllUsers() {
return new ArrayList<String>(list.keySet());
}
    public synchronized  void showAllUsers(){
        System.err.println("Printing userList list: ");
        for (String key : list.keySet()){
            System.err.println(key + "," + list.get(key));
        }
    }

class User implements java.io.Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -6699986336399821598L;
    private ArrayList<String> groups;
    private ArrayList<String> ownership;
    private String pwHash;

    public String getPwHash() {
        return pwHash;
    }

    public void setPwHash(String pwHash) {
        this.pwHash = pwHash;
    }

    public User()
    {
        groups = new ArrayList<>();
        ownership = new ArrayList<>();

    }

    public ArrayList<String> getGroups()
    {
        return groups;
    }

    public ArrayList<String> getOwnership()
    {
        return ownership;
    }

    public void addGroup(String group)
    {
        groups.add(group);
    }

    public void removeGroup(String group)
    {
        if(!groups.isEmpty())
        {
            if(groups.contains(group))
            {
                groups.remove(groups.indexOf(group));
            }
        }
    }

    public void addOwnership(String group)
    {
        ownership.add(group);
    }

    public void removeOwnership(String group)
    {
        if(!ownership.isEmpty())
        {
            if(ownership.contains(group))
            {
                ownership.remove(ownership.indexOf(group));
            }
        }
    }
}

}
