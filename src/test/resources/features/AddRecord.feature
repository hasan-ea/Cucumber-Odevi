@addrecord
Feature: Web Tables kayıt ekleme ve düzenleme

  Scenario: Yeni kayıt eklenir ve düzenlenir
    Given Kullanıcı Web Tables sayfasına gider
    When Kullanıcı ADD düğmesine tıklar
    And Kullanıcı yeni kayıt bilgilerini girer
    And Kullanıcı Submit düğmesine tıklar
    And Kullanıcı eklenen kaydı düzenler
    And Kullanıcı düzenlenen bilgileri kaydeder
    Then Kaydın değiştiği kontrol edilir
