package etml.app.meetapp.Entities;

public class CategoryEntitiy {

    int idCategory;
    String name;

    public void setId(int idCategory){
        this.idCategory = idCategory;
    }

    public int getId(){
        return idCategory;
    }

    public void setName(String newName){
        this.name = newName;
    }

    public String getName(){
        return name;
    }
}
