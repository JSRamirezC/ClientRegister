package pruebas;

import com.colfondos.pruebatecnicacol.dtos.Client;
import com.colfondos.pruebatecnicacol.exception.CustomApplicationException;
import com.colfondos.pruebatecnicacol.repository.ClientRepository;
import com.colfondos.pruebatecnicacol.services.ClientSrv;
import com.colfondos.pruebatecnicacol.services.implement.ClientSrvImpl;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testClient {

    @InjectMocks
    ClientSrv clientSrv;

    @Mock
    ClientSrvImpl clientSrvImpl;


    @Test
    public void testGuardar() throws CustomApplicationException {
        Client client= new Client();
        client.setTypeid("1");
        client.setCellphone("3054446677");
        client.setEmail("a@a.com");
        client.setNumberid(22);
        clientSrvImpl.guardarCliente(client);
        Client client2=client;
        assertEquals(client.toString(),client2.toString());

    }

}
