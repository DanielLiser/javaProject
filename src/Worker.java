import java.util.Objects;

public class Worker {
    private int id;
    private String fullName;
    private String phoneNum;
    private String userName;
    private String pass;
    public Worker(String fullName,int id,String phoneNUm,String userName,String pass){
        setId(id);
        setFullname(fullName);
        setUserName(userName);
        setPass(pass);
        setPhoneNum(phoneNum);
    }
    public Worker(String fullName,int id,String userName,String pass){
        this(fullName,id,null,userName,pass);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullname() {
        return fullName;
    }

    public void setFullname(String fullname) {
        this.fullName = fullname;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        if(phoneNum==null){
            this.phoneNum="unknown";
        }
        else{
            this.phoneNum = phoneNum;

        }
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Worker worker = (Worker) o;
        return id == worker.id;
    }

    @Override
    public int hashCode() {
       return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Worker{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", userName='" + userName + '\'' +
                ", pass='" + pass + '\'' +
                '}';
    }
}
