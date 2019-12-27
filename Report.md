# รายงานผลการทดลอง

นาย กฤษดา อุ่นสำโรง   603410194-3

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

จงอธิบายการทำงานของเมธอทต่อไปนี้ ว่าเกิดขึ้นเมื่อใดของโปรแกรม พร้อมแสดงตัวอย่างโค้ดการทำงานของเมธอท (กำหนดให้แสดง log message เมื่อมีการทำงานของเมธอท)

1. onCreate() ->

```kotlin
override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
}
```

2. onStart() ->

```kotlin
 override fun onStart(){
        super.onStart()
        Log.i("ShowLog","OnStart")

    }
```

3. onResume() ->

```kotlin
override fun onResume(){
        super.onResume()
        Log.i("ShowLog","resume")
```

4. onPause() ->

```kotlin
  override fun  onPause(){
        super. onPause()
        Log.i("ShowLog","onPause")
    }
```

5. onStop() ->

```kotlin
  override fun  onStop(){
        super. onStop()
        Log.i("ShowLog","onStop")
    }
```

6. onDestroy() ->

```kotlin
 override fun  onDestroy(){
        super. onDestroy()
        Log.i("ShowLog","onDestroy")
    }
```

7. onRestart() ->

```kotlin
override fun  onRestart(){
        super. onRestart()
        Log.i("ShowLog","onRestart")
    }
```

## Start new Activity

คำสั่งสำหรับเปิด activity ใหม่

```kotlin
bottonwellcome.setOnClickListener{View ->
            Snackbar.make( View, "Pracharat", Snackbar.LENGTH_LONG)
                .setAction("ac", null).show()
            var wc = Intent(this,WelcomeActivity::class.java)
            startActivity(wc)
        }
```

คำสั่งสำหรับเปิด activity ใหม่ ผ่านเมนู setting

```kotlin
   override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings ->{
                var sc = Intent(this,SettingActivity::class.java)
                startActivity(sc)
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
```
