# AndroidThingsDemo
android things demo，包含树莓派上运行 things 上字体修正


## 树莓派每次重启后时间都会变化，这里 terminal 设置如下命令 

####  adb root
####  adb shell settings put global ntp_server ntp1.aliyun.com 
####  adb shell setprop persist.sys.timezone "Asia/Shanghai"
####  adb reboot
