package kodlamaio.hrms.core.adapter;

public interface VerificationService {

    boolean validateByMernis(long identityId, String firstName, String lastName,int birthYear);
}
