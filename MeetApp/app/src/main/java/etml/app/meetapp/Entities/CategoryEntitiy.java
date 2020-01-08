/**
 * ETML
 * Author : Chyzhyk Aleh
 * Date : 20.11.2019
 * Description : Entity for the Category object
 */

package etml.app.meetapp.Entities;

/**
 * Entity for the Category object
 */
public class CategoryEntitiy {

    int idCategory;     // Category ID
    String name;        // Category Name

    /*Getters/Setters zone*/

    /**
     * Sets the id
     * @param idCategory
     */
    public void setId(int idCategory){
        this.idCategory = idCategory;
    }

    /**
     * Gets the id
     * @return
     */
    public int getId(){
        return idCategory;
    }

    /**
     * Sets the name
     * @param newName
     */
    public void setName(String newName){
        this.name = newName;
    }

    /**
     * Gets the name
     * @return
     */
    public String getName(){
        return name;
    }
}
