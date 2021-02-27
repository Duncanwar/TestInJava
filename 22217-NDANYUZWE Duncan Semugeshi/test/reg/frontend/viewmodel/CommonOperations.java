package reg.frontend.viewmodel;

import com.ninja_squad.dbsetup.Operations;
import com.ninja_squad.dbsetup.operation.Operation;
import java.sql.Date;
import reg.backend.domain.Gender;

// File for insert and delete data in the account
public class CommonOperations {
    public static Operation INSERT_COURSE = 
            Operations.insertInto("course")
            .columns("code","name","credits","courseFee")
            .values("C01", "Advanced Software Modeling", 3, 45000.0)
            .values("C02", "Web Technology", 4, 60000.0)
            .build();
            
    public static final Operation DELETE_COURSE= 
            Operations.deleteAllFrom("course");
    public static final Operation DELETE_STUDENT =
        Operations.deleteAllFrom("student");
    public static final Operation DELETE_REGISTRATION =
        Operations.deleteAllFrom("registration");
    public static  Operation INSERT_STUDENT =
            Operations.insertInto("student")
                .columns("studentId","name","gender", "dob")
                .values("101", "Alex", Gender.MALE,new Date(1999))
                .values("102", "Bob", Gender.FEMALE,new Date(2000))
                .build();
}
