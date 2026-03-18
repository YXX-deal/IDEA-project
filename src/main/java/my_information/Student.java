package my_information;
import lombok.Data;
public class Student {
    private String id;
    private String name;
    private int classid;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getClassid() {
        return classid;
    }
    public void setClassid(int classid) {
        this.classid = classid;
    }
}
