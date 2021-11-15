package hiber.model;

import javax.persistence.*;

@Entity
@Table(name = "cars")
public class Car {

    public Car() {

    }

    public Car(String model, int series) {
        this.model = model;
        this.series = series;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "model")
    private String model;

    @Column(name = "series")
    private int series;

    public String getModel() {
        return model;
    }

    public int getSeries() {
        return series;
    }

    @Override
    public String toString() {
        return "{" +
                "model='" + model + '\'' +
                ", series=" + series +
                '}';
    }
}
