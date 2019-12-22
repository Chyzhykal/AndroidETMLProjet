/**
 * ETML
 * Author : Chyzhyk Aleh
 * Date : 20.11.2019
 * Description : Entity for the Category object
 */

package etml.app.meetapp.Entities;

public class CategoryEntitiy {

    // Category ID
    int idCategory;
    // Category Name
    String name;

    /*Getters/Setters zone*/

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
