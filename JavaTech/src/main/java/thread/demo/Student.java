package thread.demo;

public class Student {
    private String className;
    private String name;
    private Integer score;

    public void setClassName(String className) {
        this.className = className;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getClassName() {
        return className;
    }

    public String getName() {
        return name;
    }

    public Integer getScore() {
        return score;
    }

    public Student(String className, String name, Integer score) {
        this.className = className;
        this.name = name;
        this.score = score;
    }
}
