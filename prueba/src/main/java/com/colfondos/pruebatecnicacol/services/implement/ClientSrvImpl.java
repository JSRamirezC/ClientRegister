package com.colfondos.pruebatecnicacol.services.implement;

import com.colfondos.pruebatecnicacol.dtos.Audit;
import com.colfondos.pruebatecnicacol.dtos.Client;
import com.colfondos.pruebatecnicacol.exception.CustomApplicationException;
import com.colfondos.pruebatecnicacol.repository.AuditRepository;
import com.colfondos.pruebatecnicacol.repository.ClientRepository;
import com.colfondos.pruebatecnicacol.services.ClientSrv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class ClientSrvImpl implements ClientSrv {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private AuditRepository auditRepository;

    @Override
    public void guardarCliente(Client client) throws CustomApplicationException {
        Audit audit= new Audit();
        audit.setClientinfo(client.toString());

        try {

            clientRepository.save(client);
            audit.setStatus("OK");
        } catch (Exception e) {
            audit.setStatus("NOK");
            throw new CustomApplicationException("error al intentar guardar el cliente ");
        } finally {
            try {
                Integer id= auditRepository.findAll().size()+1;
                audit.setId(id);
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern ( "yyyy-MM-dd HH:mm:ss.SSSSSS" );
                LocalDateTime fecha = LocalDateTime.now ();
                audit.setDate(dtf.format (fecha)+"");
                auditRepository.save(audit);
            } catch (Exception eX) {
                throw new CustomApplicationException("error al intentar guardar la auditoria"+ eX.getMessage());
            }
        }


    }
}
