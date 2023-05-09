package co.edu.umanizales.led_de.model.ListaDE;

import co.edu.umanizales.led_de.model.Led;
import lombok.Data;

@Data
public class Node {
    private Led data;
    private Node next;
    private Node previous;

    public Node(Led data) {
        this.data = data;
    }
}
