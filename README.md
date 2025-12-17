# Cucumber Test Otomasyon Ödevi

Bu proje, verilen ödev kapsamında **Cucumber (BDD)** yaklaşımı 
kullanılarak hazırlanmış iki farklı web test senaryosunu içermektedir.
Test otomasyonunda **Selenide**, **Cucumber** ve **TestNG** birlikte kullanılmıştır.

---

## Kullanılan Teknolojiler

- Java 17
- Maven
- Cucumber
- Selenide
- TestNG
- AssertJ

---

## Proje Yapısı

```
src
 └─ test
    ├─ java
    │  ├─ pages
    │  │  ├─ ClickMePage.java
    │  │  ├─ AddRecordPage.java
    │  │  └─ Field.java
    │  ├─ step_definitions
    │  │  ├─ ClickMeSteps.java
    │  │  └─ AddRecordSteps.java
    │  └─ runners
    │     └─ CukesRunner.java
    └─ resources
       └─ features
          ├─ ClickMe.feature
          └─ AddRecord.feature
```

- **pages**: Sayfa bazlı işlemlerin yapıldığı Page Object sınıfları
- **step_definitions**: Feature dosyalarındaki Gherkin adımlarının Java karşılıkları
- **runners**: Cucumber senaryolarını TestNG ile çalıştıran runner sınıfı
- **features**: Gherkin dili ile yazılmış test senaryoları

---

## Test Senaryoları

### 1. Click Button Testi
- `https://demoqa.com/elements` adresine gidilir
- **Buttons** sayfası açılır
- **Click Me** butonuna tıklanır
- Görünen mesajın doğru olduğu doğrulanır

### 2. Add & Edit Record Testi
- `https://demoqa.com/webtables` adresine gidilir
- **ADD** butonuna tıklanarak yeni kayıt eklenir
- Eklenen kayıt düzenlenir
- Kaydın güncellendiği kontrol edilir

---

## Çalıştırma

Testler **CukesRunner** sınıfı üzerinden çalıştırılabilir.

Alternatif olarak Maven ile:

```bash
mvn test
```