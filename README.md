# easy-verify
easy verify是一個用於解決系統開發時郵件、簡訊OTP的相關問題，每當我們在開發系統的時候都不免需要進行otp的校驗。
* 比如Register、ResetPassword、pay等場景。
* 我們在實現這些otp的時候需要在資料庫增加一些沒有必要的表用來存儲這些資訊，這會造成開發人員不變。

## 快速開始
API文檔：http://www.docway.net/project/1eiRXBlnp1l/1eillw2Lb3w

## 系統結構
Module | Intro
------ | ------
cloud-aggregation-api | API聚合服務
cloud-aggregation-h5 | H5聚合服務
cloud-common-entity | 通用公共模塊
cloud-gateway-api | api網關
cloud-gateway-h5 | h5網關
cloud-service-secret | secret微服務
cloud-service-template | template微服務
cloud-service-user | user微服務
cloud-service-verify | verify微服務

開發中，未完待續...

## Contact Author
石桂華(Skwen) https://blog.iskwen.com
# END
* Thank you for watching.