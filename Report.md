# รายงานผลการทดลอง

<ชื่อ-นามสกุล> <รหัสนักศึกษา>

## คำสั่งการแสดงผลผ่าน Logcat

Debug log

```kotlin
Log.d("showlog","logdebug")
```

Error log

```kotlin
Log.e("showlog","logerror")
```

Info log

```kotlin
Log.i("showlog","loginfo")
```

Verbose log

```kotlin
Log.v("showlog","logvervose")
```

Warning log

```kotlin
Log.w("showlog","logwarning")
```

## SNACKBAR และ TOST

คำสั่งแสดง Snackbar
เป็นตัวเเสดงข้อความ ในขณะสั้น ๆ  
```kotlin
Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
.setAction("Action", null).show()
```

คำสั่งแสดง Tost
เป็นตัวเเสดงข้อความ ในขณะสั้น ๆ คล้าย ๆ กับ Snackbas
```kotlin
Toast.makeText(this, "Show Toast", Toast.LENGTH_LONG).show()
```

## Android LiveCycle Activity

จงอธิบาการทำงานของเมธอทต่อไปนี้ ว่าเกิดขึ้นเมื่อใดของโปรแกรม พร้อมแสดงตัวอย่างโค้ดการทำงานของเมธอท (กำหนดให้แสดง log message เมื่อมีการทำงานของเมธอท)

1. onCreate() ->

```kotlin
//Add your code here
```

2. onStart() ->

```kotlin
//Add your code here
```

3. onResume() ->

```kotlin
//Add your code here
```

4. onPause() ->

```kotlin
//Add your code here
```

5. onStop() ->

```kotlin
//Add your code here
```

6. onDestroy() ->

```kotlin
//Add your code here
```

7. onRestart() ->

```kotlin
//Add your code here
```

## Start new Activity

คำสั่งสำหรับเปิด activity ใหม่

```kotlin
//Add your code here
```

คำสั่งสำหรับเปิด activity ใหม่ ผ่านเมนู setting

```kotlin
//Add your code here
```
