package Resort.Domain.Reception;

import Resort.Database.Repository;
import Resort.Domain.Register.ReceptionRegister;

import java.util.Set;

public interface ReceptionRepository extends Repository<ReceptionRegister,String> {
    Set<ReceptionRegister> getAll();
}
