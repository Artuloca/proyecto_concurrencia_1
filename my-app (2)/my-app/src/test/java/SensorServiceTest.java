import io.bootify.my_app.ASINCRONO.ConfiguracionAsincrona;
import io.bootify.my_app.SERVICIO.SensorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.concurrent.CompletableFuture;

import static org.mockito.Mockito.*;

public class SensorServiceTest {

    @Mock
    private ConfiguracionAsincrona configuracionAsincrona;

    private SensorService sensorService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        sensorService = new SensorService(configuracionAsincrona);
    }

    @Test
    public void testProcesarDatosSensores() throws Exception {
        when(configuracionAsincrona.verificarMovimiento(anyBoolean())).thenReturn(CompletableFuture.completedFuture(""));
        when(configuracionAsincrona.verificarTemperatura(anyInt())).thenReturn(CompletableFuture.completedFuture(""));
        when(configuracionAsincrona.verificarAcceso(anyBoolean())).thenReturn(CompletableFuture.completedFuture(""));

        sensorService.procesarDatosSensores(true, 20, true);

        verify(configuracionAsincrona, times(1)).verificarMovimiento(anyBoolean());
        verify(configuracionAsincrona, times(1)).verificarTemperatura(anyInt());
        verify(configuracionAsincrona, times(1)).verificarAcceso(anyBoolean());
    }
}