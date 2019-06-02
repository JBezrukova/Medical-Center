import com.MedicalCenter.DAO.*;
import com.MedicalCenter.entities.*;
import com.MedicalCenter.entities.enums.RequestReason;
import org.junit.Assert;

public class Test {

//    @org.junit.Test
//    public void addUserTest() {
//        User user = new User();
//        user.setLogin("User1");
//        UserRepository.getInstance().add(user);
//        User user1 = UserRepository.getInstance().find("User1");
//        Assert.assertEquals(user, user1);
//    }
//
//    @org.junit.Test
//    public void createRequestTest() {
//        User user = new User();
//        UserRepository.getInstance().add(user);
//        Doctor doctor = new Doctor();
//        DoctorRepository.getInstance().add(doctor);
//        Request request = user.createRequest(doctor, "07-05-2019", "10:40", RequestReason.CREATE);
//        Assert.assertNotEquals(null, request);
//    }
//
//    @org.junit.Test
//    public void createRecordTest() {
//        User user = new User();
//        UserRepository.getInstance().add(user);
//        Doctor doctor = new Doctor();
//        DoctorRepository.getInstance().add(doctor);
//        Administrator administrator = new Administrator();
//        Request request = user.createRequest(doctor, "07-05-2019", "10:40", RequestReason.CREATE);
//        administrator.approveRequest(request);
//        doctor.approveRequest(request);
//        boolean result = Record.createRecordFromRequest(request);
//        Assert.assertNotEquals(false, result);
//    }
//
//    @org.junit.Test
//    public void createRecordWithoutApproveTest() {
//        User user = new User();
//        UserRepository.getInstance().add(user);
//        Doctor doctor = new Doctor();
//        DoctorRepository.getInstance().add(doctor);
//        Request request = user.createRequest(doctor, "07-05-2019", "10:40", RequestReason.CREATE);
//        boolean result = Record.createRecordFromRequest(request);
//        Assert.assertEquals(false, result);
//    }
//
//    @org.junit.Test
//    public void createRecordWithOneApproveTest() {
//        User user = new User();
//        UserRepository.getInstance().add(user);
//        Doctor doctor = new Doctor();
//        Administrator administrator = new Administrator();
//        DoctorRepository.getInstance().add(doctor);
//        Request request = user.createRequest(doctor, "07-05-2019", "10:40", RequestReason.CREATE);
//        administrator.approveRequest(request);
//        boolean result = Record.createRecordFromRequest(request);
//        Assert.assertEquals(false, result);
//    }
//
//    @org.junit.Test
//    public void addingRecordToUserAndDoctorLists() {
//        User user = new User();
//        UserRepository.getInstance().add(user);
//        Doctor doctor = new Doctor();
//        DoctorRepository.getInstance().add(doctor);
//        Administrator administrator = new Administrator();
//        Request request = user.createRequest(doctor, "07-05-2019", "10:40", RequestReason.CREATE);
//        administrator.approveRequest(request);
//        doctor.approveRequest(request);
//        boolean result = Record.createRecordFromRequest(request);
//        Assert.assertEquals(doctor.getRecords(), user.getRecords());
//    }
//
//    @org.junit.Test
//    public void removeRecordTest() {
//        User user = new User();
//        UserRepository.getInstance().add(user);
//        Doctor doctor = new Doctor();
//        DoctorRepository.getInstance().add(doctor);
//        Administrator administrator = new Administrator();
//        Request request = user.createRequest(doctor, "07-05-2019", "10:40", RequestReason.CREATE);
//        administrator.approveRequest(request);
//        doctor.approveRequest(request);
//        boolean result = Record.createRecordFromRequest(request);
//        Request request1 = user.createRequest(doctor, "07-05-2019", "10:40", RequestReason.DELETE);
//        administrator.approveRequest(request1);
//        Record.createRecordFromRequest(request1);
//        Assert.assertEquals(null, RecordRepository.getInstance().find(request1));
//    }
//
//    @org.junit.Test
//    public void removeRecordWithoutApproveTest() {
//        User user = new User();
//        UserRepository.getInstance().add(user);
//        Doctor doctor = new Doctor();
//        DoctorRepository.getInstance().add(doctor);
//        Administrator administrator = new Administrator();
//        Request request = user.createRequest(doctor, "07-05-2019", "10:40", RequestReason.CREATE);
//        administrator.approveRequest(request);
//        doctor.approveRequest(request);
//        boolean result = Record.createRecordFromRequest(request);
//        Request request1 = user.createRequest(doctor, "07-05-2019", "10:40", RequestReason.DELETE);
//        boolean result1 = Record.createRecordFromRequest(request1);
//        Assert.assertNotEquals(true, result1);
//    }
//
//    @org.junit.Test
//    public void createRecordWithNoEmptyTime() {
//        User user = new User();
//        UserRepository.getInstance().add(user);
//        Doctor doctor = new Doctor();
//        DoctorRepository.getInstance().add(doctor);
//        Administrator administrator = new Administrator();
//        Request request = user.createRequest(doctor, "07-05-2019", "10:40", RequestReason.CREATE);
//        administrator.approveRequest(request);
//        doctor.approveRequest(request);
//        boolean result = Record.createRecordFromRequest(request);
//        Request request1 = user.createRequest(doctor, "07-05-2019", "10:40", RequestReason.CREATE);
//        Assert.assertEquals(null, request1);
//    }

    @org.junit.Test
    public void createRequestTest() {
        User user = UserDAO.getDAO().getUserByID(2);
        Doctor doctor = DoctorDAO.getDAO().getDoctorByID(2);
        Request request = user.createRequest(doctor, "07-07-2019", "10:00", RequestReason.CREATE);
        Assert.assertNotEquals(null, request);
    }

    @org.junit.Test
    public void createRecordTest() {
        User user = UserDAO.getDAO().getUserByID(2);
        Doctor doctor = DoctorDAO.getDAO().getDoctorByID(2);
        Administrator administrator = AdministratorDAO.getDAO().getAdminByLogin("admin");
        Request request = user.createRequest(doctor, "07-05-2019", "11:00", RequestReason.CREATE);
        administrator.approveRequest(request);
        doctor.approveRequest(request);
        boolean result = Record.createRecordFromRequest(request);
        Assert.assertNotEquals(false, result);
    }

    @org.junit.Test
    public void createRecordWithoutApproveTest() {
        User user = UserDAO.getDAO().getUserByID(2);
        Doctor doctor = DoctorDAO.getDAO().getDoctorByID(2);
        Request request = user.createRequest(doctor, "07-05-2019", "12:00", RequestReason.CREATE);
        boolean result = Record.createRecordFromRequest(request);
        Assert.assertEquals(false, result);
    }

    @org.junit.Test
    public void createRecordWithOneApproveTest() {
        User user = UserDAO.getDAO().getUserByID(2);
        Doctor doctor = DoctorDAO.getDAO().getDoctorByID(2);
        Administrator administrator = AdministratorDAO.getDAO().getAdminByLogin("admin");
        Request request = user.createRequest(doctor, "07-05-2019", "13:00", RequestReason.CREATE);
        administrator.approveRequest(request);
        boolean result = Record.createRecordFromRequest(request);
        Assert.assertEquals(false, result);
    }

    @org.junit.Test
    public void addingRecordToUserAndDoctorLists() {
        User user = UserDAO.getDAO().getUserByID(2);
        Doctor doctor = DoctorDAO.getDAO().getDoctorByID(2);
        Administrator administrator = AdministratorDAO.getDAO().getAdminByLogin("admin");
        Request request = user.createRequest(doctor, "07-05-2019", "14:00", RequestReason.CREATE);
        administrator.approveRequest(request);
        doctor.approveRequest(request);
        boolean result = Record.createRecordFromRequest(request);
        Assert.assertEquals(doctor.getRecords(), user.getRecords());
    }

    @org.junit.Test
    public void removeRecordWithoutApproveTest() {
        User user = UserDAO.getDAO().getUserByID(2);
        Doctor doctor = DoctorDAO.getDAO().getDoctorByID(2);
        Administrator administrator = AdministratorDAO.getDAO().getAdminByLogin("admin");
        Request request = user.createRequest(doctor, "07-05-2019", "16:00", RequestReason.CREATE);
        administrator.approveRequest(request);
        doctor.approveRequest(request);
        boolean result = Record.createRecordFromRequest(request);
        Request request1 = user.createRequest(doctor, "07-05-2019", "16:00", RequestReason.DELETE);
        boolean result1 = Record.createRecordFromRequest(request1);
        Assert.assertNotEquals(true, result1);
    }

    @org.junit.Test
    public void createRecordWithNoEmptyTime() {
        User user = UserDAO.getDAO().getUserByID(2);
        Doctor doctor = DoctorDAO.getDAO().getDoctorByID(2);
        Administrator administrator = AdministratorDAO.getDAO().getAdminByLogin("admin");
        Request request = user.createRequest(doctor, "07-05-2019", "8:00", RequestReason.CREATE);
        administrator.approveRequest(request);
        doctor.approveRequest(request);
        boolean result = Record.createRecordFromRequest(request);
        Request request1 = user.createRequest(doctor, "07-05-2019", "8:00", RequestReason.CREATE);
        Assert.assertEquals(null, request1);
}
}
