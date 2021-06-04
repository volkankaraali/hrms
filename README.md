# hrms

### veritabanı
![db2](https://user-images.githubusercontent.com/23154975/120078879-29a41000-c0ba-11eb-8abc-58763128fc52.png)

## Dosya yapısı
* Api
  * Controllers
* Config
* Core
  * Utilies
    * ImageUpload 
    * Results
  * Validation
  * Adapter
* Business
  * Abstracts
  * Concretes
* DataAccess
  * Abstracts
* Entities
  * Abstracts
  * Concretes

### #1 
* İş Posizyonları (job_titles) ekleme ve listeleme apisi yapıldı.
* İş Arayanlar(candidates) ekleme ve listeleme apisi yapıldı. ekleme yapılırken mernis doğrulaması, bilgilerin boş bırakılmaması ve email ve tcno kontrolü bulunmakta. 
ekleme islemi basarili olmasi durumunda verification_codes tablosu için kod oluşturulup tabloya kayit oluşturma ve dogrulama maili gönderme simüle edilmiştir.
* İş Verenler(employers) listeleme apisi yapıldı.


### #2
* Şehirler (cities) tablosu olsusturuldu.
* İş ilani (job_adverts) tablosu olusturuldu.
* İş ilani oluşturulması, aktif iş ilanları listeleme, aktif iş ilanlarını tarihe göre listeleme, bir firmaya (employer)'e göre iş ilanları listeleme, iş ilanını kapatma(pasif olarak aktifliğini kapatma) isterleri eklendi.

### #3
* sisteme iş arayanlar(candidates)'ın cv ekleyebilmesi için veri tabanında ilgili tablolar oluşturuldu. ve projeye dahil edildi.
* cv'nin gösterilmesi için bir dto yazıldı. 
* cv'ye koyulan fotoğrafların saklanması için dış servis olarak [cloudinary.com](https://cloudinary.com) bağlantısı yapıldı ve entegre edildi.
* giriş ekranı(login) için user classı kullanılarak dto yazıldı.
