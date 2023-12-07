import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class CarritoSauceTestUnitTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        System.out.println("QUE FUE ");
        // Iniciar el navegador Edge
        //driver = new EdgeDriver();
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @DisplayName("Prueba")
    @Execution(ExecutionMode.SAME_THREAD)
    @Test
    public void hacer_una_busqueda(){
        // Abrir la página web
        driver.get("https://www.saucedemo.com/v1/");
        //takeScreenshot(driver, "index.png");

        // Ingresar usuario y contraseña
        WebElement usernameInput = driver.findElement(By.id("user-name"));
        usernameInput.sendKeys("standard_user");

        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.sendKeys("secret_sauce");
        // takeScreenshot(driver, "password.png");

        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        // Agregar productos al carrito
        WebElement addToCartButton1 = driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']/following::button"));
        addToCartButton1.click();

        WebElement addToCartButton2 = driver.findElement(By.xpath("//div[text()='Sauce Labs Bike Light']/following::button"));
        addToCartButton2.click();

        // Captura de pantalla del proceso de login y agregado al carrito
        //takeScreenshot(driver, "screenshot.png");
    }
    @Test
    public void failSauceTest() {
        // Navegar a la página de SauceDemo
        driver.get("https://www.saucedemo.com/v1/");

        // Ingresar nombre de usuario y contraseña incorrectos
        driver.findElement(By.id("user-name")).sendKeys("fail");
        driver.findElement(By.id("password")).sendKeys("sauce");
        driver.findElement(By.id("login-button")).click();

        // Tomar captura de pantalla

        getScreenshotAs(driver, "fail.png");
        // Código para guardar la captura en un archivo
    }
    @Test
    public void sauceDemoTest() {
        // Navegar a la página de SauceDemo
        driver.get("https://www.saucedemo.com/v1/");

        // Ingresar nombre de usuario y contraseña
        WebElement username = driver.findElement(By.id("user-name"));
        username.sendKeys("standard_user");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        // Resto del código de la prueba...
        // Nota: Agrega aquí el resto del código de la prueba
        // Seleccionar 3 productos
        List<WebElement> productAddButtons = driver.findElements(By.xpath("//button[@class='btn_primary btn_inventory']"));
        for (int i = 0; i < 3; i++) {
            productAddButtons.get(i).click();
        }

        // Captura de pantalla de la selección de productos
        // Ir al carrito de compra
        WebElement cartIcon = driver.findElement(By.className("shopping_cart_link"));
        cartIcon.click();


        // Captura de pantalla del carrito de compra
        getScreenshotAs (driver, "cart.png");
        // Código para guardar la captura en un archivo

        // Hacer clic en el botón de checkout
        WebElement checkoutButton = driver.findElement(By.cssSelector(".checkout_button"));
        checkoutButton.click();

        // Captura de pantalla después de hacer clic en el botón de checkout
        getScreenshotAs (driver, "checkout.png");
        // Código para guardar la captura en un archivo

        // Completar los campos de información de compra
        WebElement firstName = driver.findElement(By.id("first-name"));
        firstName.sendKeys("Chris");
        WebElement lastName = driver.findElement(By.id("last-name"));
        lastName.sendKeys("Automatización");
        WebElement zipCode = driver.findElement(By.id("postal-code"));
        zipCode.sendKeys("507");

        // Captura de pantalla después de ingresar información de compra
        getScreenshotAs (driver, "form.png");
        // Código para guardar la captura en un archivo

        // Hacer clic en el botón de continuar
        WebElement continueButton = driver.findElement(By.cssSelector(".cart_button"));
        continueButton.click();

        // Captura de pantalla después de hacer clic en el botón de continuar
        getScreenshotAs (driver, "continue.png");
        // Código para guardar la captura en un archivo

        // Hacer clic en el botón de finalizar compra
        WebElement finishButton = driver.findElement(By.cssSelector(".cart_button"));
        finishButton.click();

        // Captura de pantalla después de hacer clic en el botón de finalizar compra
        getScreenshotAs (driver, "Finish.png");

    }
    @Test
    public void loginToSauceDemo() {
        // Navigate to the SauceDemo website
        driver.get("https://www.saucedemo.com/v1/");

        // Enter the username and password
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        // Click the login button
        driver.findElement(By.id("login-button")).click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public  void sauceShop() {

        // Abrir la página web
        driver.get("https://www.saucedemo.com");
        getScreenshotAs(driver, "index.png");

        // Ingresar usuario y contraseña
        WebElement usernameInput = driver.findElement(By.id("user-name"));
        usernameInput.sendKeys("standard_user");

        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        // Agregar productos al carrito
        WebElement addToCartButton1 = driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']/following::button"));
        addToCartButton1.click();

        WebElement addToCartButton2 = driver.findElement(By.xpath("//div[text()='Sauce Labs Bike Light']/following::button"));
        addToCartButton2.click();

        // Captura de pantalla del proceso de login y agregado al carrito
        getScreenshotAs(driver, "screenshot_login_and_cart.png");

        // Ir al carrito de compra y hacer clic en el botón "checkout"
        WebElement cartButton = driver.findElement(By.className("shopping_cart_link"));
        cartButton.click();

        WebElement checkoutButton = driver.findElement(By.id("checkout"));
        checkoutButton.click();

        // Tomar una captura de pantalla usando el navegador Edge
        getScreenshotAs(driver, "screenshot_checkout_edge.png");
    }

    private static void getScreenshotAs(WebDriver driver, String fileName) {
        // Tomar captura de pantalla
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            // Guardar la captura de pantalla en un archivo
            Files.move(screenshot.toPath(), new File(fileName).toPath());
            System.out.println("Captura de pantalla guardada como " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @After
    public void tearDown() {
        // Cerrar el navegador después de la prueba
        if (driver != null) {
            driver.quit();
        }
    }

}
