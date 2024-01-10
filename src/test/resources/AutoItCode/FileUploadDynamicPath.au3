ControlFocus("Open", "", "Edit1")
$filePath=$CmdLine[1]
ControlSetText("Open","","Edit1",$filePath)
sleep(3000)
ControlClick("Open","","Button1")