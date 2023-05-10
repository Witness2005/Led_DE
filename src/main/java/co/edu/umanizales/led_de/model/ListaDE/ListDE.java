package co.edu.umanizales.led_de.model.ListaDE;

import co.edu.umanizales.led_de.model.Led;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data

public class ListDE {
    private Node head;


    private int size;





    public void add(Led led) {
        if (head == null) {
            head = new Node(led);
        } else {
            Node newNode = new Node(led);
            Node temp = head;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(newNode);
            newNode.setPrevious(temp);
        }

        size++;
    }
    public List<Led> toList() {
        List<Led> leds = new ArrayList<>();
        Node temp = head;

        while (temp != null) {
            leds.add(temp.getData());
            temp = temp.getNext();
        }

        return leds;
    }

    public void addToStart(Led led) {
        if (head != null) {
            Node newNode = new Node(led);
            newNode.setNext(head);
            head = newNode;
        } else {
            head = new Node(led);
        }
        size++;
    }



}

