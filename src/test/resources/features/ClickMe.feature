@clickme
  Feature: Click Me butonu mesaj doğrulama
    Kullanıcı Click Me butonuna tıkladığında
    ekranda doğru bilgilendirme mesajı görüntülenmelidir.
  Scenario: Click Me butonuna tıklanması
    Given Kullanıcı elements sayfasındadır
    When Kullanıcı button sekmesine gider
    And Kullanıcı Click Me butonuna tıklar
    Then Mesajın doğruluğu kontrol edilir