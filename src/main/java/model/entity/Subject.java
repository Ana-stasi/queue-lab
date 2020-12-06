package model.entity;

public class Subject {
    private int id;
    private String name;
    private String href;
    private String image;
    private String altName;

    public Subject(int id, String name, String href, String image, String altName) {
        this.id = id;
        this.name = name;
        this.href = href;
        this.image = image;
        this.altName = altName;
    }

    public Subject(String name, String href, String image, String alt_name) {
    }
    public Subject(String name){
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getHref() {
        return href;
    }

    public String getImage() {
        return image;
    }

    public String getAltName() {
        return altName;
    }

    @Override
    public String toString() {
        return id+" "+ name+ " "+href+" "+image+" "+altName;
    }
}
