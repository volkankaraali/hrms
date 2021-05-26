package kodlamaio.hrms.core.adapter;

import org.springframework.stereotype.Service;
import tr.gov.nvi.tckimlik.ws.KPSPublic;
import tr.gov.nvi.tckimlik.ws.KPSPublicSoap;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.Locale;

@Service
public class MernisServiceAdapter implements VerificationService {
    @Override
    public boolean validateByMernis(long identityId, String firstName, String lastName, int birthYear) {
        String endpoint="https://tckimlik.nvi.gov.tr/Service/KPSPublic.asmx";
        URL url= null;
        try {
            url = URI.create(endpoint).toURL();
        } catch (MalformedURLException e) {

            e.printStackTrace();
        }
        KPSPublic service=new KPSPublic(url);
        KPSPublicSoap port=service.getPort(KPSPublicSoap.class);

        return port.tcKimlikNoDogrula(identityId,
                firstName.toUpperCase(new Locale("tr"))
                ,lastName.toUpperCase(new Locale("tr")),birthYear);
    }
}
