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
จงอธิบาการทำงานของเมธอทต่อไปนี้ ว่าเกิดขึ้นเมื่อใดของโปรแกรม พร้อมแสดงตัวอย่างโค้ดการทำงานของเมธอท (กำหนดให้แสดง log message เมื่อมีการทำงานของเมธอท)

1. onCreate() ->
        Android จะเรียก onCreate() เมื่อ Activity Start ในหนึ่งช่วงเวลาของ Application นั้น อาจมีการ Create และ Destroy Activity อยู่เรื่อยๆ ยกตัวอย่างเช่น เมื่อ User ทำการ Rotate Screen จะส่งผลให้ Activity ถูก Destroy และ Instance ใหม่ของ Activity เดิมก็จะถูก Create อีกครั้ง
```kotlin
override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
}
```

2. onStart() ->
        หลัง จาก onCreate() ถูกเรียก onStart() ก็จะถูกเรียกตามมา ถ้าหาก Application ของเราถูกสั่งให้ไปอยู่ใน Background (อาจจะโดยการสั่ง Launch Application อื่น เหนือ Application ของเรา) onStart() จะถูกเรียกเมื่อเรากลับมาที่ Application อีกครั้ง
```kotlin
 override fun onStart(){
        super.onStart()
        Log.i("ShowLog","OnStart")

    }
```

3. onResume() ->
        เมื่อ Application ของเราถูก Start ขึ้นมา onResume() จะถูกเรียกหลังจาก onCreate() และ onStart() หรือเมื่อ Application เปลี่ยนสถานะจาก Background กลับมาอยู่บน Foreground อีกครั้ง onResume() ก็จะถูกเรียกเช่นเดียวกัน onResume() จะถูกเรียก ก่อนที่ Activity จะสามารถมองเห็นได้บน Screen
```kotlin
override fun onResume(){
        super.onResume()
        Log.i("ShowLog","resume")
```

4. onPause() ->
        onPause() จะถูกเรียก เมื่อ Application กำลังเปลี่ยนจากสถานะ Foreground ไปยัง Background ถ้าหากเรามีการประมวลผลอะไรก็ตามที่ควรจะ Run เฉพาะตอนที่ Activity อยู่บน Screen (ยกตัวอย่างเช่น การแสดง Animation) เราควรจะสั่งหยุดการประมวลผลดังกล่าวใน onPause()
onPause() จะถูกเรียก ในเวลาที่เราสั่ง Launch Activity อื่น ขึ้นมาอยู่เหนือ Activity ที่กำลังแสดงผลอยู่ Application อาจถูก Kill เมื่อ System อยู่ในสภาวะ Low Resources ซึ่งกระบวนการ Kill จะเกิดขึ้นหลังจาก onPause() ซึ่งไม่ได้เกิดเป็นปกติ แต่อย่างน้อยก็ควรเตรียมรับมือไว้
onPause() เป็น Method ที่สำคัญ เพราะเป็นเหมือนการเตือนครั้งสุดท้ายก่อนที่ Activity ของเราจะหายออกจาก Screen ซึ่ง Method นี้ เป็นที่ที่เราควรจะ Save ข้อมูลที่สำคัญลง Disk, Database หรือ Preference
```kotlin
  override fun  onPause(){
        super. onPause()
        Log.i("ShowLog","onPause")
    }
```

5. onStop() ->
        onStop() จะถูกเรียกเมื่อ Activity ออกจาก Screen เรียบร้อยแล้ว หรือเมื่อเราเปลี่ยนไป Interact กับอีก Activity หนึ่งแทน (เปลี่ยนจากสถานะ Active ไปเป็น Inactive) แต่นี่ไม่ได้หมายความ Activity ถูกปิดตัวลง เพียงแค่เปลี่ยนมาอยู่ในสถานะ Inactive ถ้าหากเรามีการประมวลผลใดที่ต้องการ Run เฉพาะตอนที่ Active นี่คือ Method ที่เหมาะสมที่เราจะสั่งหยุดการประมวลผลดังกล่าว
```kotlin
  override fun  onStop(){
        super. onStop()
        Log.i("ShowLog","onStop")
    }
```

6. onDestroy() ->
        onDestroy() เป็น method สุดท้ายที่จะถูกเรียก ก่อนที่ Activity จะปิดตัวลงอย่างถาวร เป็น Method ที่เราใช้ในการคืนค่า resources หรือ clean up ใดๆ ก่อนที่ Activity จะถูกเก็บกวาดด้วย Garbage Collector ภายใน Method นี้ เราควรจะสั่งปิด Process ใดๆที่เราสั่ง Run ไว้ใน Background
```kotlin
 override fun  onDestroy(){
        super. onDestroy()
        Log.i("ShowLog","onDestroy")
    }
```

7. onRestart() ->
        หลัง จาก onCreate() ถูกเรียก onStart() ก็จะถูกเรียกตามมา ถ้าหาก Application ของเราถูกสั่งให้ไปอยู่ใน Background (อาจจะโดยการสั่ง Launch Application อื่น เหนือ Application ของเรา) onStart() จะถูกเรียกเมื่อเรากลับมาที่ Application อีกครั้ง
```kotlin
override fun  onRestart(){
        super. onRestart()
        Log.i("ShowLog","onRestart")
    }
```

## Start new Activity

คำสั่งสำหรับเปิด activity ใหม่
        ในการเปิด activity ใหม่ ไปที่ file new จากนั้นสร้าง Activity ที่เราต้องการ จากนั้นทำการออกแบบที่หน้า Design จากนั้นลงโค๊ดที่ หน้า Text ดังโค๊ดต่อไปนี้
```kotlin
bottonwellcome.setOnClickListener{View ->
            Snackbar.make( View, "Pracharat", Snackbar.LENGTH_LONG)
                .setAction("ac", null).show()
            var wc = Intent(this,WelcomeActivity::class.java)
            startActivity(wc)
        }
```

คำสั่งสำหรับเปิด activity ใหม่ ผ่านเมนู setting
        ในการเปิด activity ใหม่ ผ่านเมนู setting จะคล้าย ๆ โดยการลิ๊งค์ไปหน้าที่เราต้องการ
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
