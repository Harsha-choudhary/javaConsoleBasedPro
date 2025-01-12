/*
 * package model;
 * 
 * 
 * import lombok.AllArgsConstructor; import lombok.Data; import
 * lombok.NoArgsConstructor;
 * 
 * @Data
 * 
 * @AllArgsConstructor
 * 
 * @NoArgsConstructor
 * 
 * 
 * 
 * public class Doctor { private int id; private String name; private String
 * specialization;
 * 
 * public Doctor(int id, String name, String specialization) { this.id = id;
 * this.name = name; this.specialization = specialization; }
 * 
 * // Getter and setter methods (if needed)
 * 
 * // Override toString method to display meaningful information
 * 
 * @Override public String toString() { return "Doctor [ID=" + id + ", Name=" +
 * name + ", Specialization=" + specialization + "]"; } }
 */

package model;

public class Doctor {
    private int id;
    private String name;
    private String specialization;

    // No-argument constructor
   // public Doctor() {}

    // Constructor with parameters
    public Doctor(int id, String name, String specialization) {
        this.id = id;
        this.name = name;
        this.specialization = specialization;
    }

    // Getter and setter methods
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    // Override toString method to display meaningful information
    @Override
    public String toString() {
        return "Doctor{id=" + id + ", name='" + name + "', specialization='" + specialization + "'}";
    }
}
