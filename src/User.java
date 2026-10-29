public abstract class User {
    protected String username;
    protected String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean Login(String inputUser, String inpusPass) {
        return this.username.equals(inputUser) && this.password.equals(inpusPass);
    }
    
    //abstrak metod untuk polymorphism
    public abstract void displayRole();
}