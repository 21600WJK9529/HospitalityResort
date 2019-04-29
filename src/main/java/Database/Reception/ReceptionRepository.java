package Database.Reception;

import Database.Repository;
import Register.ReceptionRegister;

import java.util.Set;

public interface ReceptionRepository extends Repository<ReceptionRegister,String> {
    Set<ReceptionRegister> getAll();
}
