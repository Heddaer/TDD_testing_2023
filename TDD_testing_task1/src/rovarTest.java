import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
class rovarTest {

    @Test
    void enrovLOWER() {
        assertEquals("abobcocdodefofgoghohijojkoklolmomnonopopqoqrorsostotuvovxoxyzozåäö",rovar.enrov("abcdefghijklmnopqrstuvxyzåäö"));
    }
    @Test
    void enrovUPPER() {
        assertEquals("ABOBCOCDODEFOFGOGHOHIJOJKOKLOLMOMNONOPOPQOQRORSOSTOTUVOVXOXYCOCÅÄÖ", rovar.enrov("ABCDEFGHIJKLMNOPQRSTUVXYCÅÄÖ"));
    }
    @Test
    void enrovNUMBER() {
        assertEquals("0123456789", rovar.enrov("0123456789"));
    }
    @Test
    void enrovSYMBOLS() {
        assertEquals("e.gog. !”#€%&/(),.", rovar.enrov("e.g. !”#€%&/(),."));
    }
    @Test
    void enrovEmtyString() {
        assertEquals("",rovar.enrov(""));
    }
    @Test
    void enrovNULL() {
        assertEquals(null, rovar.enrov(null));
    }

    @Test
    void derovLOWER() {
        assertEquals("abcdefghijklmnopqrstuvxyzåäö",rovar.derov("abobcocdodefofgoghohijojkoklolmomnonopopqoqrorsostotuvovxoxyzozåäö"));
    }
    @Test
    void derovUPPER() {
        assertEquals("ABCDEFGHIJKLMNOPQRSTUVXYCÅÄÖ", rovar.derov("ABOBCOCDODEFOFGOGHOHIJOJKOKLOLMOMNONOPOPQOQRORSOSTOTUVOVXOXYCOCÅÄÖ"));
    }
    @Test
    void derovNUMBER() {
        assertEquals("0123456789", rovar.derov("0123456789"));
    }
    @Test
    void derovSYMBOLS() {
        assertEquals("e.g. !”#€%&/(),.", rovar.derov("e.gog. !”#€%&/(),."));
    }
    @Test
    void derovEmptyString() {
        assertEquals("",rovar.derov(""));
    }
    @Test
    void derovNULL() {
        assertEquals(null, rovar.derov(null));
    }




}