package techproed.d09;


/*
    1. PointerInput Objesinin Olusturulmasi:
       PointerInput finger = new PointerInput (PointerInput.Kind.TOUCH, "finger");
       PointerInput: Obje olusturmak icin kullanilan sinif.
       finger: Olusturulan PointerInput objesine bir isim atar.
       PointerInput.Kind.TOUCH: Hangi tur dokunmatik etkilesimlerin temsil edilecegini belirtir.
       "TOUCH", dokunmatik ekran etkilesimlerini temsil eder.

    2. Sequence(Sira) Olusturulmasi:
       Sequence sequence = new Sequence (finger, 1);
       Sequence: Yapilacak adimlarin belirli bir sira ve duzen icinde yapilmasi icin kullanilir.
       finger: PointerInput objesidir.
       1: Adimlarin sayisini belirtir. Bu durumda, bir tane etkilesim adimi gerceklestirilecek.

    3. Etkilesimin Adimlarinin Eklenmesi:
       addAction(): Sirayla etkilesim adimlari eklenir,
        * createPointerMove(): Belirli bir koordinata gitme islemi.
        * createPointerDown(): Parmak ile basma islemi.
        * Pause(): Belirli bir sure bekleme islemi.
        * createPointerUp(): Parmagi kaldirma islemi.
        * Origin.viewport(): Etkilesimin yapilacagi koordinati belirtir.
        * MouseButton.LEFT.asArg(): Etkilesimde kullanilacak fare dugmesini belirtir.
    Ornek (Tap Islemi):
        .addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), x, y));
        .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        .addAction(new Pause(finger, Duration.ofMillis(300)));
        .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

    4. Islemin Gerceklestirilmesi:
       driver.perform(Collections.singletonList(sequence)); // Bu kod ile olusturdugumuz islem sirasini gerceklestiriyoruz.
       driver.perfomr(Arrays.asList(sequence1, sequence2));

 */

import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.testng.annotations.Test;
import techproed.basetest.ApiDemosBaseTest;

import java.time.Duration;
import java.util.Collections;

public class C15_PointerInput_Tap extends ApiDemosBaseTest {
    @Test
    public void testTap() throws InterruptedException {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");

        Sequence sequence = new Sequence(finger, 1)
                // Parmak ekran uzerindeki tap yapilacak koordinata hareket ettirilir.
                .addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), 1139, 1745))
                // Parmak ile, farenin sol tusuna basar gibi ekranda belirledigimiz koordinata bastik.
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                // Ekranda parmagin basili olarak duracagi sureyi belirledik.
                .addAction(new Pause(finger, Duration.ofMillis(300)))
                // Parmagi ekranda bastigimiz koordinattan kaldirdik.
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        // Sirali adimlari topluca eyleme donusturduk.
        driver.perform(Collections.singletonList(sequence));

        Thread.sleep(3000);




    }
}
