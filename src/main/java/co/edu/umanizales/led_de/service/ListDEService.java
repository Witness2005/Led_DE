package co.edu.umanizales.led_de.service;




import co.edu.umanizales.led_de.model.ListaDE.ListDE;


import lombok.Data;
import org.springframework.stereotype.Service;

@Service
@Data
public class ListDEService {
    private ListDE leds;
    public ListDEService() {
        leds = new ListDE();




    }


}

