package com.olimpico.proyectoOlimpico.services;

import com.olimpico.proyectoOlimpico.model.DetInveProd;
import com.olimpico.proyectoOlimpico.model.DetInveProdId;
import com.olimpico.proyectoOlimpico.repo.DetInveProdRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetInveProdServices {

    private final DetInveProdRepository detInveProdRepository;

    public DetInveProdServices(DetInveProdRepository detInveProdRepository) {
        this.detInveProdRepository = detInveProdRepository;
    }

    //

    public List<DetInveProd> getAllDeInve()
    {
        return  detInveProdRepository.findAll();
    }

    //

    public DetInveProd getDetInveProdById(DetInveProdId id)
    {
        return detInveProdRepository.findById(id).orElse(null);
    }

    //

    public  DetInveProd saveDetInvProd(DetInveProd detInveProd)
    {
        return  detInveProdRepository.save(detInveProd);
    }

    //

    public void deleteDetInvProd(DetInveProdId id)
    {
        detInveProdRepository.deleteById(id);
    }

}
