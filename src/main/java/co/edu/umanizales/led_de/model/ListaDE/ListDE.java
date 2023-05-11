package co.edu.umanizales.led_de.model.ListaDE;

import co.edu.umanizales.led_de.model.Led;
import lombok.Data;

import java.time.LocalTime;
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



    public void addFirst(Led led) {
        Node newNode = new Node(led);
        if (head == null) {
            head = newNode;
        } else {
            newNode.setNext(head);
            head.setPrevious(newNode);
            head = newNode;
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
    public void turnOn() {
    Node temp = head;
    while (temp != null) {
        temp.getData().setState(true);
        temp = temp.getNext();
    }



}

    public void reboot() {
        Node temp = head;
        while (temp != null) {
            temp.getData().setState(false);
            temp = temp.getNext();
        }



    }
    public void blink() {
        if (head != null) {
            Node temp = head;
            int count = 1;
            int start;
            if ((size % 2) != 0) {
                start = (size / 2) + 1;
                while (temp != null) {
                    if (count == start) {
                        Node tempNext = temp;
                        temp.getData().setState(true);
                        temp.getData().setDateOn(LocalTime.now());

                        while (tempNext.getNext() != null) {
                            long startMillis = System.currentTimeMillis();
                            long elapsedMillis = 0;

                            while (elapsedMillis < 1000) {
                                elapsedMillis = System.currentTimeMillis() - startMillis;
                            }

                            temp.getData().setState(false);
                            temp.getData().setDateOff(LocalTime.now());
                            tempNext.getData().setState(false);
                            tempNext.getData().setDateOff(LocalTime.now());

                            temp = temp.getPrevious();
                            tempNext = tempNext.getNext();

                            temp.getData().setState(true);
                            temp.getData().setDateOn(LocalTime.now());
                            tempNext.getData().setState(true);
                            tempNext.getData().setDateOn(LocalTime.now());
                        }
                        break;
                    }
                    count++;
                    temp = temp.getNext();
                }
            } else {
                start = size / 2;
                while (temp != null) {
                    if (count == start) {
                        Node tempNext = temp.getNext();
                        temp.getData().setState(true);
                        temp.getData().setDateOn(LocalTime.now());
                        tempNext.getData().setState(true);
                        tempNext.getData().setDateOn(LocalTime.now());

                        while (tempNext.getNext() != null) {
                            long startMilliSeconds = System.currentTimeMillis();
                            long elapsedMilliSeconds = 0;

                            while (elapsedMilliSeconds < 1000) {
                                elapsedMilliSeconds = System.currentTimeMillis() - startMilliSeconds;
                            }

                            temp.getData().setState(false);
                            temp.getData().setDateOff(LocalTime.now());
                            tempNext.getData().setState(false);
                            tempNext.getData().setDateOff(LocalTime.now());

                            temp = temp.getPrevious();
                            tempNext = tempNext.getNext();

                            temp.getData().setState(true);
                            temp.getData().setDateOn(LocalTime.now());
                            tempNext.getData().setState(true);
                            tempNext.getData().setDateOn(LocalTime.now());
                        }
                        break;
                    }
                    count++;
                    temp = temp.getNext();
                }
            }
        }
    }



}

