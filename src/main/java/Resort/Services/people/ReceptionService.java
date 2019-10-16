package Resort.Services.people;

import Resort.Domain.Register.Reception.ReceptionRegister;
import Resort.Services.IService;

import java.util.Set;

public interface ReceptionService extends IService <ReceptionRegister,String> {
    Set<ReceptionRegister> getAll();
}
