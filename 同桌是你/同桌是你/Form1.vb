'------------------------------------------------------------------------------------------------------------------------------
'整体实现思路：通过2个数组2个集合实现所有数据的操作。
'
'集合1  List1 存放81个button   
'集合2  List2 存放已选择的button  
'数组1  Arr1  存放判断的元素，如果被选中则为1 否则为0
'数组2  Arr2  存放读取的学生名单
'
'设置
'当用户在选择位置时，此时Arr1内数据发生变化，有具体的1或者0
'当用户保存位置时，（先使集合2为空）此时通过一个循环将对应Arr1中所选择的button从集合1按顺序放进了集合2（设置和设置界面的返回键均显隐集合1，而开始键盘和开始界面的返回键显隐集合2[由于初始时集合2为空，所以开始键盘应在设置的保存键盘按下后才可使用。]）
'当用户恢复默认位置时，需要实现所有Button.Enabled为true  数组1为全1  
'
'开始
'当点击“开始\继续”。首先当第一次点击时，lab11.text为Arr(1),lab12.text = list2（i）.text（不断闪烁），list2(i).backcolor=blue
'在点击“停”时，在点击事件中实现，将此时List2.Item(i).Text=Arr2(j) (名字赋值给对应Button) , 并把这个button从List2中删除 removeat(i)
'------------------------------------------------------------------------------------------------------------------------------

Public Class Form1

    '--------------------------------------------------------------------------------------------------------------------------
    '以下5个属性为移动控件所需
    Dim MovBoll As Boolean
    Dim CurrX As Integer
    Dim CurrY As Integer
    Dim MousX As Integer
    Dim MousY As Integer
    '--------------------------------------------------------------------------------------------------------------------------
    '以下为各个数组集合的定义

    '  存放初始座位号          81个
    '  存放是否选择的0或1      81个
    'Dim Arr1() As String = {"A1", "A2", "A3", "A4", "A5", "A6", "A7", "A8", "A9", "B1", "B2", "B3", "B4", "B5", "B6", "B7", "B8", "B9", "C1", "C2", "C3", "C4", "C5", "C6", "C7", "C8", "C9", "D1", "D2", "D3", "D4", "D5", "D6", "D7", "D8", "D9", "E1", "E2", "E3", "E4", "E5", "E6", "E7", "E8", "E9", "F1", "F2", "F3", "F4", "F5", "F6", "F7", "F8", "F9", "G1", "G2", "G3", "G4", "G5", "G6", "G7", "G8", "G9", "H1", "H2", "H3", "H4", "H5", "H6", "H7", "H8", "H9", "I1", "I2", "I3", "I4", "I5", "I6", "I7", "I8", "I9"}
    Dim Arr1() As Integer = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
    Dim Arr2() As String    '  存放学生名单 （读取）从1开始

    Dim List1 As New ArrayList()        '存放81个button
    Dim List2 As New ArrayList()        '存放已选择的button

    Dim i As Integer = 0        'List2(i)
    Dim j As Integer = 1        'Arr2(j)
    Dim n As Integer = 80
    Dim num1 As Integer = 0     '选取的座位数 List2 实际减1
    Dim num2 As Integer = 0     '学生人数      Arr2  实际减1
    Dim key1 As Integer = 0     '是否已经有名单
    Dim key2 As Integer = 0     '是否已经保存座位
    Dim key3 As Integer = 0
    Dim key4 As Integer = 0
    Dim key5 As Integer = 0      '是否已经进入“开始”
    Dim key6 As Integer = 0      '是否第一次进入“关于”

    '--------------------------------------------------------------------------------------------------------------------------
    '这里是List1 的初始化，在加载中执行  √
    Public Sub Form1_Load(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles MyBase.Load

        Me.KeyPreview = True '注册窗体的键盘事件

        Label12.BackColor = Color.Transparent
        Label12.Parent = PictureBox1
         
        Label11.BackColor = Color.Transparent
        Label11.Parent = PictureBox1

        PictureBox00.BackColor = Color.Transparent
        PictureBox00.Parent = PictureBox0

        PictureBox01.BackColor = Color.Transparent
        PictureBox01.Parent = PictureBox0

        PictureBox31.BackColor = Color.Transparent
        PictureBox31.Parent = PictureBox3

        PictureBox32.BackColor = Color.Transparent
        PictureBox32.Parent = PictureBox3

        PictureBoxX1.BackColor = Color.Transparent
        PictureBoxX1.Parent = PictureBox1

        PictureBoxX2.BackColor = Color.Transparent
        PictureBoxX2.Parent = PictureBox1

        PictureBoxX3.BackColor = Color.Transparent
        PictureBoxX3.Parent = PictureBox1

        PictureBoxX8.BackColor = Color.Transparent
        PictureBoxX8.Parent = PictureBox1

        PictureBoxX12.BackColor = Color.Transparent
        PictureBoxX12.Parent = PictureBox1

        PictureBoxSJT.BackColor = Color.Transparent
        PictureBoxSJT.Parent = PictureBox0

        List1.Add(ButtonA1)
        List1.Add(ButtonA2)
        List1.Add(ButtonA3)
        List1.Add(ButtonA4)
        List1.Add(ButtonA5)
        List1.Add(ButtonA6)
        List1.Add(ButtonA7)
        List1.Add(ButtonA8)
        List1.Add(ButtonA9)

        List1.Add(ButtonB1)
        List1.Add(ButtonB2)
        List1.Add(ButtonB3)
        List1.Add(ButtonB4)
        List1.Add(ButtonB5)
        List1.Add(ButtonB6)
        List1.Add(ButtonB7)
        List1.Add(ButtonB8)
        List1.Add(ButtonB9)

        List1.Add(ButtonC1)
        List1.Add(ButtonC2)
        List1.Add(ButtonC3)
        List1.Add(ButtonC4)
        List1.Add(ButtonC5)
        List1.Add(ButtonC6)
        List1.Add(ButtonC7)
        List1.Add(ButtonC8)
        List1.Add(ButtonC9)

        List1.Add(ButtonD1)
        List1.Add(ButtonD2)
        List1.Add(ButtonD3)
        List1.Add(ButtonD4)
        List1.Add(ButtonD5)
        List1.Add(ButtonD6)
        List1.Add(ButtonD7)
        List1.Add(ButtonD8)
        List1.Add(ButtonD9)

        List1.Add(ButtonE1)
        List1.Add(ButtonE2)
        List1.Add(ButtonE3)
        List1.Add(ButtonE4)
        List1.Add(ButtonE5)
        List1.Add(ButtonE6)
        List1.Add(ButtonE7)
        List1.Add(ButtonE8)
        List1.Add(ButtonE9)

        List1.Add(ButtonF1)
        List1.Add(ButtonF2)
        List1.Add(ButtonF3)
        List1.Add(ButtonF4)
        List1.Add(ButtonF5)
        List1.Add(ButtonF6)
        List1.Add(ButtonF7)
        List1.Add(ButtonF8)
        List1.Add(ButtonF9)

        List1.Add(ButtonG1)
        List1.Add(ButtonG2)
        List1.Add(ButtonG3)
        List1.Add(ButtonG4)
        List1.Add(ButtonG5)
        List1.Add(ButtonG6)
        List1.Add(ButtonG7)
        List1.Add(ButtonG8)
        List1.Add(ButtonG9)

        List1.Add(ButtonH1)
        List1.Add(ButtonH2)
        List1.Add(ButtonH3)
        List1.Add(ButtonH4)
        List1.Add(ButtonH5)
        List1.Add(ButtonH6)
        List1.Add(ButtonH7)
        List1.Add(ButtonH8)
        List1.Add(ButtonH9)

        List1.Add(ButtonI1)
        List1.Add(ButtonI2)
        List1.Add(ButtonI3)
        List1.Add(ButtonI4)
        List1.Add(ButtonI5)
        List1.Add(ButtonI6)
        List1.Add(ButtonI7)
        List1.Add(ButtonI8)
        List1.Add(ButtonI9)
    End Sub
    '----------------------------------------------------------------------------------------------------------


    '--------------------------------------------------------------------------------------------------------------------------
    '这里是可拖动图的代码部分   √
    Private Sub PictureBox21_MouseDown(ByVal sender As Object, ByVal e As System.Windows.Forms.MouseEventArgs) Handles PictureBox21.MouseDown
        MousX = e.X             '鼠标按下时记录下x y 的值
        MousY = e.Y
        MovBoll = True
    End Sub
    Private Sub PictureBox21_MouseMove(ByVal sender As Object, ByVal e As System.Windows.Forms.MouseEventArgs) Handles PictureBox21.MouseMove
        If MovBoll = True Then  '按下时移动鼠标更改位置
            CurrX = PictureBox21.Left - MousX + e.X
            CurrY = PictureBox21.Top - MousY + e.Y
            PictureBox21.Location = New Point(CurrX, CurrY)
        End If
    End Sub
    Private Sub PictureBox21_MouseUp(ByVal sender As Object, ByVal e As System.Windows.Forms.MouseEventArgs) Handles PictureBox21.MouseUp
        MovBoll = False
    End Sub

    Private Sub PictureBox22_MouseDown(ByVal sender As Object, ByVal e As System.Windows.Forms.MouseEventArgs) Handles PictureBox22.MouseDown
        MousX = e.X             '鼠标按下时记录下x y 的值
        MousY = e.Y
        MovBoll = True
    End Sub
    Private Sub PictureBox22_MouseMove(ByVal sender As Object, ByVal e As System.Windows.Forms.MouseEventArgs) Handles PictureBox22.MouseMove
        If MovBoll = True Then  '按下时移动鼠标更改位置
            CurrX = PictureBox22.Left - MousX + e.X
            CurrY = PictureBox22.Top - MousY + e.Y
            PictureBox22.Location = New Point(CurrX, CurrY)
        End If
    End Sub
    Private Sub PictureBox22_MouseUp(ByVal sender As Object, ByVal e As System.Windows.Forms.MouseEventArgs) Handles PictureBox22.MouseUp
        MovBoll = False
    End Sub

    Private Sub PictureBox23_MouseDown(ByVal sender As Object, ByVal e As System.Windows.Forms.MouseEventArgs) Handles PictureBox23.MouseDown
        MousX = e.X             '鼠标按下时记录下x y 的值
        MousY = e.Y
        MovBoll = True
    End Sub
    Private Sub PictureBox23_MouseMove(ByVal sender As Object, ByVal e As System.Windows.Forms.MouseEventArgs) Handles PictureBox23.MouseMove
        If MovBoll = True Then  '按下时移动鼠标更改位置
            CurrX = PictureBox23.Left - MousX + e.X
            CurrY = PictureBox23.Top - MousY + e.Y
            PictureBox23.Location = New Point(CurrX, CurrY)
        End If
    End Sub
    Private Sub PictureBox23_MouseUp(ByVal sender As Object, ByVal e As System.Windows.Forms.MouseEventArgs) Handles PictureBox23.MouseUp
        MovBoll = False
    End Sub

    Private Sub PictureBox24_MouseDown(ByVal sender As Object, ByVal e As System.Windows.Forms.MouseEventArgs) Handles PictureBox24.MouseDown
        MousX = e.X             '鼠标按下时记录下x y 的值
        MousY = e.Y
        MovBoll = True
    End Sub
    Private Sub PictureBox24_MouseMove(ByVal sender As Object, ByVal e As System.Windows.Forms.MouseEventArgs) Handles PictureBox24.MouseMove
        If MovBoll = True Then  '按下时移动鼠标更改位置
            CurrX = PictureBox24.Left - MousX + e.X
            CurrY = PictureBox24.Top - MousY + e.Y
            PictureBox24.Location = New Point(CurrX, CurrY)
        End If
    End Sub
    Private Sub PictureBox24_MouseUp(ByVal sender As Object, ByVal e As System.Windows.Forms.MouseEventArgs) Handles PictureBox24.MouseUp
        MovBoll = False
    End Sub

   

    '---------------------------√----------------------延时器的代码-----------------------------------------------------------

    Public Sub Timer1_Tick(sender As Object, e As EventArgs) Handles Timer1.Tick
        '此时i=0 
        List2.Item(i).BackColor = Color.Aqua

        Label12.Text = List2.Item(i).text

        If i = 0 Then
            List2.Item(num1 - 1).BackColor = Color.White
        End If

        If i <> 0 Then
            List2.Item(i - 1).BackColor = Color.White
        End If

        i = i + 1
        If i = num1 Then
            i = 0
        End If
    End Sub


    Private Sub Timer2_Tick(sender As Object, e As EventArgs) Handles Timer2.Tick

        PictureBoxSJT.Visible = True

        Timer3.Enabled = True
        Timer2.Enabled = False

      
    End Sub

    Private Sub Timer3_Tick(sender As Object, e As EventArgs) Handles Timer3.Tick
        PictureBoxSJT.Visible = False

        Timer2.Enabled = True
        Timer3.Enabled = False

    End Sub
  
     
    '---------------------------------------------------初始界面中的事件-------------------------------------------------------
    '开始按钮                   √
    Private Sub Button01_Click(sender As Object, e As EventArgs) Handles Button01.Click
        Dim i As Integer
        key5 = 1
        For i = 0 To num1 - 1
            List2.Item(i).Visible = True
            List2.Item(i).Enabled = True
            List2.Item(i).BackColor = Color.White
            'List2.Item(i).ForeColor = Color.Black
        Next

        PictureBox0.Visible = False
        Button01.Visible = False
        Button02.Visible = False
        Button03.Visible = False
        PictureBox01.Visible = False

        PictureBox1.Visible = True
        PictureBox21.Visible = True
        PictureBox22.Visible = True
        PictureBox23.Visible = True
        PictureBox24.Visible = True

        Label11.Visible = True
        Label12.Visible = True
        Button11.Visible = True
        Button12.Visible = True
        ' Button13.Visible = True

        Label11.Text = Arr2(1)


    End Sub

    '设置按钮                   √
    Private Sub Button02_Click(sender As Object, e As EventArgs) Handles Button02.Click
        PictureBox0.Visible = False
        Button01.Visible = False
        Button02.Visible = False
        Button03.Visible = False

        PictureBoxTZSN.Visible = True
        PictureBox2.Visible = True
        PictureBox21.Visible = True
        PictureBox22.Visible = True
        PictureBox23.Visible = True
        PictureBox24.Visible = True

        Button21.Visible = True
        Button22.Visible = True
        Button24.Visible = True
        Button25.Visible = True

        ButtonA1.Visible = True
        ButtonA2.Visible = True
        ButtonA3.Visible = True
        ButtonA4.Visible = True
        ButtonA5.Visible = True
        ButtonA6.Visible = True
        ButtonA7.Visible = True
        ButtonA8.Visible = True
        ButtonA9.Visible = True

        ButtonB1.Visible = True
        ButtonB2.Visible = True
        ButtonB3.Visible = True
        ButtonB4.Visible = True
        ButtonB5.Visible = True
        ButtonB6.Visible = True
        ButtonB7.Visible = True
        ButtonB8.Visible = True
        ButtonB9.Visible = True

        ButtonC1.Visible = True
        ButtonC2.Visible = True
        ButtonC3.Visible = True
        ButtonC4.Visible = True
        ButtonC5.Visible = True
        ButtonC6.Visible = True
        ButtonC7.Visible = True
        ButtonC8.Visible = True
        ButtonC9.Visible = True

        ButtonD1.Visible = True
        ButtonD2.Visible = True
        ButtonD3.Visible = True
        ButtonD4.Visible = True
        ButtonD5.Visible = True
        ButtonD6.Visible = True
        ButtonD7.Visible = True
        ButtonD8.Visible = True
        ButtonD9.Visible = True

        ButtonE1.Visible = True
        ButtonE2.Visible = True
        ButtonE3.Visible = True
        ButtonE4.Visible = True
        ButtonE5.Visible = True
        ButtonE6.Visible = True
        ButtonE7.Visible = True
        ButtonE8.Visible = True
        ButtonE9.Visible = True

        ButtonF1.Visible = True
        ButtonF2.Visible = True
        ButtonF3.Visible = True
        ButtonF4.Visible = True
        ButtonF5.Visible = True
        ButtonF6.Visible = True
        ButtonF7.Visible = True
        ButtonF8.Visible = True
        ButtonF9.Visible = True

        ButtonG1.Visible = True
        ButtonG2.Visible = True
        ButtonG3.Visible = True
        ButtonG4.Visible = True
        ButtonG5.Visible = True
        ButtonG6.Visible = True
        ButtonG7.Visible = True
        ButtonG8.Visible = True
        ButtonG9.Visible = True

        ButtonH1.Visible = True
        ButtonH2.Visible = True
        ButtonH3.Visible = True
        ButtonH4.Visible = True
        ButtonH5.Visible = True
        ButtonH6.Visible = True
        ButtonH7.Visible = True
        ButtonH8.Visible = True
        ButtonH9.Visible = True

        ButtonI1.Visible = True
        ButtonI2.Visible = True
        ButtonI3.Visible = True
        ButtonI4.Visible = True
        ButtonI5.Visible = True
        ButtonI6.Visible = True
        ButtonI7.Visible = True
        ButtonI8.Visible = True
        ButtonI9.Visible = True
         
    End Sub
    '关于按钮                   √
    Private Sub Button03_Click(sender As Object, e As EventArgs) Handles Button03.Click
        PictureBox0.Visible = False
        Button01.Visible = False
        Button02.Visible = False
        Button03.Visible = False

        PictureBox3.Visible = True
        PictureBox31.Visible = True
        PictureBox32.Visible = True
        Button33.Visible = True
        Label31.Visible = True
    End Sub


    '---------------------------------------------------开始中的事件-----------------------------------------------------------
    '“开始/继续”按钮的部分   √
    Private Sub Button11_Click(sender As Object, e As EventArgs) Handles Button11.Click
        Button12.Enabled = True
        Button11.Enabled = False
        Timer1.Enabled = True
        Label11.Text = Arr2(j)
        Button13.Visible = False
    End Sub
    '“暂停”按钮的部分        √
    Private Sub Button12_Click(sender As Object, e As EventArgs) Handles Button12.Click
        Timer1.Enabled = False

        Button12.Enabled = False
        Button11.Enabled = True

        Dim Rand1 As Integer
        Dim Rand2 As New Random

        Rand1 = Rand2.Next(1, 101) '   （a,b）包括a 不包括b  根据概率来随机显示一个图片

        If i <> 0 Then
            List2.Item(i - 1).text = Arr2(j)
            List2.RemoveAt(i - 1)
        End If

        If i = 0 Then
            List2.Item(num1 - 1).text = Arr2(j)
            List2.RemoveAt(num1 - 1)
        End If

        i = 0
        num1 = num1 - 1
        j = j + 1

        If j = num2 + 1 Then
            Button11.Visible = False
            Button12.Visible = False
            Label11.Visible = False
            Label12.Visible = False

            Button14.Visible = True
        End If

        If num1 = 1 And j <> num2 + 1 Then
            List2.Item(0).text = Arr2(j)
            List2.Item(0).BackColor = Color.Aqua

            Button11.Visible = False
            Button12.Visible = False
            Label11.Visible = False
            Label12.Visible = False

            Button14.Visible = True
        End If

        If Rand1 > 90 Then
            PictureBoxX1.Visible = False
            PictureBoxX2.Visible = False
            PictureBoxX3.Visible = False
            PictureBoxX4.Visible = False
            PictureBoxX5.Visible = False
            PictureBoxX6.Visible = False
            PictureBoxX7.Visible = False
            PictureBoxX8.Visible = False
            PictureBoxX9.Visible = False
            PictureBoxX10.Visible = False
            PictureBoxX11.Visible = False
            PictureBoxX12.Visible = False

            PictureBoxX5.Visible = True
        End If

        If Rand1 > 80 And Rand1 < 91 Then
            PictureBoxX1.Visible = False
            PictureBoxX2.Visible = False
            PictureBoxX3.Visible = False
            PictureBoxX4.Visible = False
            PictureBoxX5.Visible = False
            PictureBoxX6.Visible = False
            PictureBoxX7.Visible = False
            PictureBoxX8.Visible = False
            PictureBoxX9.Visible = False
            PictureBoxX10.Visible = False
            PictureBoxX11.Visible = False
            PictureBoxX12.Visible = False

            PictureBoxX6.Visible = True
        End If

        If Rand1 > 70 And Rand1 < 81 Then
            PictureBoxX1.Visible = False
            PictureBoxX2.Visible = False
            PictureBoxX3.Visible = False
            PictureBoxX4.Visible = False
            PictureBoxX5.Visible = False
            PictureBoxX6.Visible = False
            PictureBoxX7.Visible = False
            PictureBoxX8.Visible = False
            PictureBoxX9.Visible = False
            PictureBoxX10.Visible = False
            PictureBoxX11.Visible = False
            PictureBoxX12.Visible = False

            PictureBoxX7.Visible = True
        End If

        If Rand1 > 60 And Rand1 < 71 Then
            PictureBoxX1.Visible = False
            PictureBoxX2.Visible = False
            PictureBoxX3.Visible = False
            PictureBoxX4.Visible = False
            PictureBoxX5.Visible = False
            PictureBoxX6.Visible = False
            PictureBoxX7.Visible = False
            PictureBoxX8.Visible = False
            PictureBoxX9.Visible = False
            PictureBoxX10.Visible = False
            PictureBoxX11.Visible = False
            PictureBoxX12.Visible = False

            PictureBoxX8.Visible = True
        End If

        If Rand1 > 53 And Rand1 < 61 Then
            PictureBoxX1.Visible = False
            PictureBoxX2.Visible = False
            PictureBoxX3.Visible = False
            PictureBoxX4.Visible = False
            PictureBoxX5.Visible = False
            PictureBoxX6.Visible = False
            PictureBoxX7.Visible = False
            PictureBoxX8.Visible = False
            PictureBoxX9.Visible = False
            PictureBoxX10.Visible = False
            PictureBoxX11.Visible = False
            PictureBoxX12.Visible = False

            PictureBoxX1.Visible = True
        End If

        If Rand1 > 46 And Rand1 < 54 Then
            PictureBoxX1.Visible = False
            PictureBoxX2.Visible = False
            PictureBoxX3.Visible = False
            PictureBoxX4.Visible = False
            PictureBoxX5.Visible = False
            PictureBoxX6.Visible = False
            PictureBoxX7.Visible = False
            PictureBoxX8.Visible = False
            PictureBoxX9.Visible = False
            PictureBoxX10.Visible = False
            PictureBoxX11.Visible = False
            PictureBoxX12.Visible = False

            PictureBoxX2.Visible = True
        End If

        If Rand1 > 39 And Rand1 < 47 Then
            PictureBoxX1.Visible = False
            PictureBoxX2.Visible = False
            PictureBoxX3.Visible = False
            PictureBoxX4.Visible = False
            PictureBoxX5.Visible = False
            PictureBoxX6.Visible = False
            PictureBoxX7.Visible = False
            PictureBoxX8.Visible = False
            PictureBoxX9.Visible = False
            PictureBoxX10.Visible = False
            PictureBoxX11.Visible = False
            PictureBoxX12.Visible = False

            PictureBoxX3.Visible = True
        End If

        If Rand1 > 32 And Rand1 < 40 Then
            PictureBoxX1.Visible = False
            PictureBoxX2.Visible = False
            PictureBoxX3.Visible = False
            PictureBoxX4.Visible = False
            PictureBoxX5.Visible = False
            PictureBoxX6.Visible = False
            PictureBoxX7.Visible = False
            PictureBoxX8.Visible = False
            PictureBoxX9.Visible = False
            PictureBoxX10.Visible = False
            PictureBoxX11.Visible = False
            PictureBoxX12.Visible = False

            PictureBoxX4.Visible = True
        End If

        If Rand1 > 25 And Rand1 < 33 Then
            PictureBoxX1.Visible = False
            PictureBoxX2.Visible = False
            PictureBoxX3.Visible = False
            PictureBoxX4.Visible = False
            PictureBoxX5.Visible = False
            PictureBoxX6.Visible = False
            PictureBoxX7.Visible = False
            PictureBoxX8.Visible = False
            PictureBoxX9.Visible = False
            PictureBoxX10.Visible = False
            PictureBoxX11.Visible = False
            PictureBoxX12.Visible = False

            PictureBoxX9.Visible = True
        End If

        If Rand1 > 18 And Rand1 < 26 Then
            PictureBoxX1.Visible = False
            PictureBoxX2.Visible = False
            PictureBoxX3.Visible = False
            PictureBoxX4.Visible = False
            PictureBoxX5.Visible = False
            PictureBoxX6.Visible = False
            PictureBoxX7.Visible = False
            PictureBoxX8.Visible = False
            PictureBoxX9.Visible = False
            PictureBoxX10.Visible = False
            PictureBoxX11.Visible = False
            PictureBoxX12.Visible = False

            PictureBoxX10.Visible = True
        End If

        If Rand1 > 11 And Rand1 < 19 Then
            PictureBoxX1.Visible = False
            PictureBoxX2.Visible = False
            PictureBoxX3.Visible = False
            PictureBoxX4.Visible = False
            PictureBoxX5.Visible = False
            PictureBoxX6.Visible = False
            PictureBoxX7.Visible = False
            PictureBoxX8.Visible = False
            PictureBoxX9.Visible = False
            PictureBoxX10.Visible = False
            PictureBoxX11.Visible = False
            PictureBoxX12.Visible = False

            PictureBoxX11.Visible = True
        End If

        If Rand1 > 5 And Rand1 < 12 Then
            PictureBoxX1.Visible = False
            PictureBoxX2.Visible = False
            PictureBoxX3.Visible = False
            PictureBoxX4.Visible = False
            PictureBoxX5.Visible = False
            PictureBoxX6.Visible = False
            PictureBoxX7.Visible = False
            PictureBoxX8.Visible = False
            PictureBoxX9.Visible = False
            PictureBoxX10.Visible = False
            PictureBoxX11.Visible = False
            PictureBoxX12.Visible = False

            PictureBoxX12.Visible = True
        End If

    End Sub
    '“返回主菜单”按钮的部分  √
    Private Sub Button13_Click(sender As Object, e As EventArgs) Handles Button13.Click
        Dim i As Integer

        For i = 0 To num1 - 1
            List2.Item(i).Visible = False
        Next

        Timer1.Enabled = False
        Button02.Enabled = False

        PictureBox0.Visible = True
        Button01.Visible = True
        Button02.Visible = True
        Button03.Visible = True
        PictureBox01.Visible = True

        PictureBox1.Visible = False
        PictureBox21.Visible = False
        PictureBox22.Visible = False
        PictureBox23.Visible = False
        PictureBox24.Visible = False

        Label11.Visible = False
        Label12.Visible = False
        Button11.Visible = False
        Button12.Visible = False
        Button13.Visible = False
    End Sub
    '“截图并保存”按钮的部分  √
    Private Sub Button14_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button14.Click
        Dim b As Bitmap = New Bitmap(Screen.PrimaryScreen.WorkingArea.Width, Screen.PrimaryScreen.WorkingArea.Height)
        Dim g As Graphics = Graphics.FromImage(b)
        Dim s As Size = New Size(Screen.PrimaryScreen.WorkingArea.Width, Screen.PrimaryScreen.WorkingArea.Height)
        Dim saveDlg As SaveFileDialog = New SaveFileDialog
        Dim dlgResult As DialogResult = New DialogResult

        g.CopyFromScreen(0, 0, 0, 0, s, CopyPixelOperation.SourceCopy)
        g.Dispose()

        saveDlg.Filter = "JPEG Files (*.jpg)|*.jpg"
        saveDlg.Title = "保存..."
        dlgResult = saveDlg.ShowDialog
        If dlgResult = Windows.Forms.DialogResult.OK Then
            b.Save(saveDlg.FileName)
            Button14.Enabled = False
            Button14.Text = "已经保存好啦！"
        End If

        b = Nothing
    End Sub
    '“更换主题”按钮的部分
    Private Sub PictureBox00_Click(sender As Object, e As EventArgs) Handles PictureBox00.Click
        MessageBox.Show("你点我干啥！我还在睡觉呢Zzzz（未完成）")
    End Sub
    '“帮助”按钮的部分       √
    Private Sub PictureBox01_Click(sender As Object, e As EventArgs) Handles PictureBox01.Click
        Label00.Visible = True
        Timer2.Enabled = False
        Timer3.Enabled = False
        PictureBoxSJT.Visible = False
    End Sub
    '“关闭帮助”的按钮       √
    Private Sub Label00_Click(sender As Object, e As EventArgs) Handles Label00.Click
        Label00.Visible = False
    End Sub
    '“键盘事件”             √
    Private Sub Form1_KeyDown(ByVal sender As Object, ByVal e As System.Windows.Forms.KeyEventArgs) Handles Me.KeyDown
        If e.KeyCode = Keys.Space Then Dosomething()
    End Sub
    Private Sub Dosomething()
        If key5 = 1 And Button12.Enabled = True Then
            Timer1.Enabled = False

            Button12.Enabled = False
            Button11.Enabled = True

            Dim Rand1 As Integer
            Dim Rand2 As New Random

            Rand1 = Rand2.Next(1, 101) '   （a,b）包括a 不包括b  根据概率来随机显示一个图片

            If i <> 0 Then
                List2.Item(i - 1).text = Arr2(j)
                List2.RemoveAt(i - 1)
            End If

            If i = 0 Then
                List2.Item(num1 - 1).text = Arr2(j)
                List2.RemoveAt(num1 - 1)
            End If

            i = 0
            num1 = num1 - 1
            j = j + 1

            If j = num2 + 1 Then
                Button11.Visible = False
                Button12.Visible = False
                Label11.Visible = False
                Label12.Visible = False
                Button14.Visible = True
            End If

            If num1 = 1 And j <> num2 + 1 Then
                List2.Item(0).text = Arr2(j)
                List2.Item(0).BackColor = Color.Aqua

                Button11.Visible = False
                Button12.Visible = False
                Label11.Visible = False
                Label12.Visible = False
                Button14.Visible = True
            End If

            If Rand1 > 90 Then
                PictureBoxX1.Visible = False
                PictureBoxX2.Visible = False
                PictureBoxX3.Visible = False
                PictureBoxX4.Visible = False
                PictureBoxX5.Visible = False
                PictureBoxX6.Visible = False
                PictureBoxX7.Visible = False
                PictureBoxX8.Visible = False
                PictureBoxX9.Visible = False
                PictureBoxX10.Visible = False
                PictureBoxX11.Visible = False
                PictureBoxX12.Visible = False

                PictureBoxX5.Visible = True
            End If

            If Rand1 > 80 And Rand1 < 91 Then
                PictureBoxX1.Visible = False
                PictureBoxX2.Visible = False
                PictureBoxX3.Visible = False
                PictureBoxX4.Visible = False
                PictureBoxX5.Visible = False
                PictureBoxX6.Visible = False
                PictureBoxX7.Visible = False
                PictureBoxX8.Visible = False
                PictureBoxX9.Visible = False
                PictureBoxX10.Visible = False
                PictureBoxX11.Visible = False
                PictureBoxX12.Visible = False

                PictureBoxX6.Visible = True
            End If

            If Rand1 > 70 And Rand1 < 81 Then
                PictureBoxX1.Visible = False
                PictureBoxX2.Visible = False
                PictureBoxX3.Visible = False
                PictureBoxX4.Visible = False
                PictureBoxX5.Visible = False
                PictureBoxX6.Visible = False
                PictureBoxX7.Visible = False
                PictureBoxX8.Visible = False
                PictureBoxX9.Visible = False
                PictureBoxX10.Visible = False
                PictureBoxX11.Visible = False
                PictureBoxX12.Visible = False

                PictureBoxX7.Visible = True
            End If

            If Rand1 > 60 And Rand1 < 71 Then
                PictureBoxX1.Visible = False
                PictureBoxX2.Visible = False
                PictureBoxX3.Visible = False
                PictureBoxX4.Visible = False
                PictureBoxX5.Visible = False
                PictureBoxX6.Visible = False
                PictureBoxX7.Visible = False
                PictureBoxX8.Visible = False
                PictureBoxX9.Visible = False
                PictureBoxX10.Visible = False
                PictureBoxX11.Visible = False
                PictureBoxX12.Visible = False

                PictureBoxX8.Visible = True
            End If

            If Rand1 > 53 And Rand1 < 61 Then
                PictureBoxX1.Visible = False
                PictureBoxX2.Visible = False
                PictureBoxX3.Visible = False
                PictureBoxX4.Visible = False
                PictureBoxX5.Visible = False
                PictureBoxX6.Visible = False
                PictureBoxX7.Visible = False
                PictureBoxX8.Visible = False
                PictureBoxX9.Visible = False
                PictureBoxX10.Visible = False
                PictureBoxX11.Visible = False
                PictureBoxX12.Visible = False

                PictureBoxX1.Visible = True
            End If

            If Rand1 > 46 And Rand1 < 54 Then
                PictureBoxX1.Visible = False
                PictureBoxX2.Visible = False
                PictureBoxX3.Visible = False
                PictureBoxX4.Visible = False
                PictureBoxX5.Visible = False
                PictureBoxX6.Visible = False
                PictureBoxX7.Visible = False
                PictureBoxX8.Visible = False
                PictureBoxX9.Visible = False
                PictureBoxX10.Visible = False
                PictureBoxX11.Visible = False
                PictureBoxX12.Visible = False

                PictureBoxX2.Visible = True
            End If

            If Rand1 > 39 And Rand1 < 47 Then
                PictureBoxX1.Visible = False
                PictureBoxX2.Visible = False
                PictureBoxX3.Visible = False
                PictureBoxX4.Visible = False
                PictureBoxX5.Visible = False
                PictureBoxX6.Visible = False
                PictureBoxX7.Visible = False
                PictureBoxX8.Visible = False
                PictureBoxX9.Visible = False
                PictureBoxX10.Visible = False
                PictureBoxX11.Visible = False
                PictureBoxX12.Visible = False

                PictureBoxX3.Visible = True
            End If

            If Rand1 > 32 And Rand1 < 40 Then
                PictureBoxX1.Visible = False
                PictureBoxX2.Visible = False
                PictureBoxX3.Visible = False
                PictureBoxX4.Visible = False
                PictureBoxX5.Visible = False
                PictureBoxX6.Visible = False
                PictureBoxX7.Visible = False
                PictureBoxX8.Visible = False
                PictureBoxX9.Visible = False
                PictureBoxX10.Visible = False
                PictureBoxX11.Visible = False
                PictureBoxX12.Visible = False

                PictureBoxX4.Visible = True
            End If

            If Rand1 > 25 And Rand1 < 33 Then
                PictureBoxX1.Visible = False
                PictureBoxX2.Visible = False
                PictureBoxX3.Visible = False
                PictureBoxX4.Visible = False
                PictureBoxX5.Visible = False
                PictureBoxX6.Visible = False
                PictureBoxX7.Visible = False
                PictureBoxX8.Visible = False
                PictureBoxX9.Visible = False
                PictureBoxX10.Visible = False
                PictureBoxX11.Visible = False
                PictureBoxX12.Visible = False

                PictureBoxX9.Visible = True
            End If

            If Rand1 > 18 And Rand1 < 26 Then
                PictureBoxX1.Visible = False
                PictureBoxX2.Visible = False
                PictureBoxX3.Visible = False
                PictureBoxX4.Visible = False
                PictureBoxX5.Visible = False
                PictureBoxX6.Visible = False
                PictureBoxX7.Visible = False
                PictureBoxX8.Visible = False
                PictureBoxX9.Visible = False
                PictureBoxX10.Visible = False
                PictureBoxX11.Visible = False
                PictureBoxX12.Visible = False

                PictureBoxX10.Visible = True
            End If

            If Rand1 > 11 And Rand1 < 19 Then
                PictureBoxX1.Visible = False
                PictureBoxX2.Visible = False
                PictureBoxX3.Visible = False
                PictureBoxX4.Visible = False
                PictureBoxX5.Visible = False
                PictureBoxX6.Visible = False
                PictureBoxX7.Visible = False
                PictureBoxX8.Visible = False
                PictureBoxX9.Visible = False
                PictureBoxX10.Visible = False
                PictureBoxX11.Visible = False
                PictureBoxX12.Visible = False

                PictureBoxX11.Visible = True
            End If

            If Rand1 > 5 And Rand1 < 12 Then
                PictureBoxX1.Visible = False
                PictureBoxX2.Visible = False
                PictureBoxX3.Visible = False
                PictureBoxX4.Visible = False
                PictureBoxX5.Visible = False
                PictureBoxX6.Visible = False
                PictureBoxX7.Visible = False
                PictureBoxX8.Visible = False
                PictureBoxX9.Visible = False
                PictureBoxX10.Visible = False
                PictureBoxX11.Visible = False
                PictureBoxX12.Visible = False

                PictureBoxX12.Visible = True
            End If
        End If
    End Sub
   



    '---------------------------------------------------设置中的事件-----------------------------------------------------------
    '“恢复默认” 按钮的部分   √
    Private Sub Button21_Click(sender As Object, e As EventArgs) Handles Button21.Click
        Dim i As Integer
        For i = 0 To 80
            Arr1(i) = 1
        Next

        ButtonA1.Enabled = True
        ButtonA2.Enabled = True
        ButtonA3.Enabled = True
        ButtonA4.Enabled = True
        ButtonA5.Enabled = True
        ButtonA6.Enabled = True
        ButtonA7.Enabled = True
        ButtonA8.Enabled = True
        ButtonA9.Enabled = True

        ButtonB1.Enabled = True
        ButtonB2.Enabled = True
        ButtonB3.Enabled = True
        ButtonB4.Enabled = True
        ButtonB5.Enabled = True
        ButtonB6.Enabled = True
        ButtonB7.Enabled = True
        ButtonB8.Enabled = True
        ButtonB9.Enabled = True

        ButtonC1.Enabled = True
        ButtonC2.Enabled = True
        ButtonC3.Enabled = True
        ButtonC4.Enabled = True
        ButtonC5.Enabled = True
        ButtonC6.Enabled = True
        ButtonC7.Enabled = True
        ButtonC8.Enabled = True
        ButtonC9.Enabled = True

        ButtonD1.Enabled = True
        ButtonD2.Enabled = True
        ButtonD3.Enabled = True
        ButtonD4.Enabled = True
        ButtonD5.Enabled = True
        ButtonD6.Enabled = True
        ButtonD7.Enabled = True
        ButtonD8.Enabled = True
        ButtonD9.Enabled = True

        ButtonE1.Enabled = True
        ButtonE2.Enabled = True
        ButtonE3.Enabled = True
        ButtonE4.Enabled = True
        ButtonE5.Enabled = True
        ButtonE6.Enabled = True
        ButtonE7.Enabled = True
        ButtonE8.Enabled = True
        ButtonE9.Enabled = True

        ButtonF1.Enabled = True
        ButtonF2.Enabled = True
        ButtonF3.Enabled = True
        ButtonF4.Enabled = True
        ButtonF5.Enabled = True
        ButtonF6.Enabled = True
        ButtonF7.Enabled = True
        ButtonF8.Enabled = True
        ButtonF9.Enabled = True

        ButtonG1.Enabled = True
        ButtonG2.Enabled = True
        ButtonG3.Enabled = True
        ButtonG4.Enabled = True
        ButtonG5.Enabled = True
        ButtonG6.Enabled = True
        ButtonG7.Enabled = True
        ButtonG8.Enabled = True
        ButtonG9.Enabled = True

        ButtonH1.Enabled = True
        ButtonH2.Enabled = True
        ButtonH3.Enabled = True
        ButtonH4.Enabled = True
        ButtonH5.Enabled = True
        ButtonH6.Enabled = True
        ButtonH7.Enabled = True
        ButtonH8.Enabled = True
        ButtonH9.Enabled = True

        ButtonI1.Enabled = True
        ButtonI2.Enabled = True
        ButtonI3.Enabled = True
        ButtonI4.Enabled = True
        ButtonI5.Enabled = True
        ButtonI6.Enabled = True
        ButtonI7.Enabled = True
        ButtonI8.Enabled = True
        ButtonI9.Enabled = True

    End Sub
    '“保存座位”按钮的部分    √
    Private Sub Button22_Click(sender As Object, e As EventArgs) Handles Button22.Click
        key3 = 1
        Dim i As Integer
        Dim j As Integer


        If key2 = 1 Then                '先清空集合2
            For i = 0 To num1 - 1
                List2.RemoveAt(0)
            Next

            num1 = 0
        End If

        For j = 0 To 80
            If Arr1(j) = 0 Then
                List2.Add(List1(j))
                num1 = num1 + 1
            End If
        Next

        If num1 = 0 Then
            MessageBox.Show("你还没有选择座位哦！")
        End If

        If num1 <> 0 Then
            key2 = 1
            MessageBox.Show("已保存所选位置啦！")
        End If

        If key3 = 1 And key4 = 1 Then
            Button25.Enabled = True
        End If



    End Sub

    '“读取名单”按钮的部分    √
    Private Sub Button24_Click(sender As Object, e As EventArgs) Handles Button24.Click
        key4 = 1
        Dim FireName As String

        If OpenFileDialog1.ShowDialog() = DialogResult.OK Then
            Dim sr As New System.IO.StreamReader(OpenFileDialog1.FileName)
            FireName = OpenFileDialog1.FileName
            sr.Close()
        End If
        '取得txt文件地址
        Dim txt As IO.StreamReader = New IO.StreamReader(FireName, System.Text.Encoding.Default)

        Do Until txt.EndOfStream
            num2 = num2 + 1
            ReDim Preserve Arr2(num2) '数组从1开始
            Arr2(num2) = txt.ReadLine()
        Loop

        txt.Close()
        key1 = 1
        'Timer1.Enabled = True
        Button24.Text = "读取完成啦！"
        Button24.Enabled = False
        '将此文件的名字赋到数组Arr2（）
        If key3 = 1 And key4 = 1 Then
            Button25.Enabled = True
        End If
    End Sub
    '“返回主菜单”按钮的部分  √
    Private Sub Button25_Click(sender As Object, e As EventArgs) Handles Button25.Click
        PictureBox2.Visible = False
        PictureBox21.Visible = False
        PictureBox22.Visible = False
        PictureBox23.Visible = False
        PictureBox24.Visible = False
        PictureBoxTZSN.Visible = False

        Button21.Visible = False
        Button22.Visible = False
        Button24.Visible = False
        Button25.Visible = False

        ButtonA1.Visible = False
        ButtonA2.Visible = False
        ButtonA3.Visible = False
        ButtonA4.Visible = False
        ButtonA5.Visible = False
        ButtonA6.Visible = False
        ButtonA7.Visible = False
        ButtonA8.Visible = False
        ButtonA9.Visible = False

        ButtonB1.Visible = False
        ButtonB2.Visible = False
        ButtonB3.Visible = False
        ButtonB4.Visible = False
        ButtonB5.Visible = False
        ButtonB6.Visible = False
        ButtonB7.Visible = False
        ButtonB8.Visible = False
        ButtonB9.Visible = False

        ButtonC1.Visible = False
        ButtonC2.Visible = False
        ButtonC3.Visible = False
        ButtonC4.Visible = False
        ButtonC5.Visible = False
        ButtonC6.Visible = False
        ButtonC7.Visible = False
        ButtonC8.Visible = False
        ButtonC9.Visible = False

        ButtonD1.Visible = False
        ButtonD2.Visible = False
        ButtonD3.Visible = False
        ButtonD4.Visible = False
        ButtonD5.Visible = False
        ButtonD6.Visible = False
        ButtonD7.Visible = False
        ButtonD8.Visible = False
        ButtonD9.Visible = False

        ButtonE1.Visible = False
        ButtonE2.Visible = False
        ButtonE3.Visible = False
        ButtonE4.Visible = False
        ButtonE5.Visible = False
        ButtonE6.Visible = False
        ButtonE7.Visible = False
        ButtonE8.Visible = False
        ButtonE9.Visible = False

        ButtonF1.Visible = False
        ButtonF2.Visible = False
        ButtonF3.Visible = False
        ButtonF4.Visible = False
        ButtonF5.Visible = False
        ButtonF6.Visible = False
        ButtonF7.Visible = False
        ButtonF8.Visible = False
        ButtonF9.Visible = False

        ButtonG1.Visible = False
        ButtonG2.Visible = False
        ButtonG3.Visible = False
        ButtonG4.Visible = False
        ButtonG5.Visible = False
        ButtonG6.Visible = False
        ButtonG7.Visible = False
        ButtonG8.Visible = False
        ButtonG9.Visible = False

        ButtonH1.Visible = False
        ButtonH2.Visible = False
        ButtonH3.Visible = False
        ButtonH4.Visible = False
        ButtonH5.Visible = False
        ButtonH6.Visible = False
        ButtonH7.Visible = False
        ButtonH8.Visible = False
        ButtonH9.Visible = False

        ButtonI1.Visible = False
        ButtonI2.Visible = False
        ButtonI3.Visible = False
        ButtonI4.Visible = False
        ButtonI5.Visible = False
        ButtonI6.Visible = False
        ButtonI7.Visible = False
        ButtonI8.Visible = False
        ButtonI9.Visible = False

        PictureBox0.Visible = True
        Button01.Visible = True
        Button02.Visible = True
        Button03.Visible = True

        Dim k As Integer = 0   'k,temp在乱序中使用
        Dim temp As Integer
        Dim r As New Random
        List2.Add(Button13)

        If key1 = 1 And key2 = 1 Then           '当名单和位置都选择好以后，使开始按钮可用，并且此时打乱座位集合（List2）
            Button01.Enabled = True
            Button02.Enabled = False


            For k = 0 To num1 - 1

                temp = r.Next(0, num1)

                List2.Item(num1) = List2.Item(0)
                List2.Item(0) = List2.Item(temp)
                List2.Item(temp) = List2.Item(num1)

            Next

        End If

        List2.RemoveAt(num1)
    End Sub



    '---------------------------------------------------关于中的事件-----------------------------------------------------------
    '“同桌是你”按钮的部分    √
    Private Sub PictureBox31_Click(sender As Object, e As EventArgs) Handles PictureBox31.Click
        Label32.Visible = False
        Label31.Visible = True
    End Sub
    '“欧阳青星”按钮的部分    √
    Private Sub PictureBox32_Click(sender As Object, e As EventArgs) Handles PictureBox32.Click
        Label31.Visible = False
        Label32.Visible = True
    End Sub
    '“返回主菜单”按钮的部分  √
    Private Sub Button33_Click(sender As Object, e As EventArgs) Handles Button33.Click
        PictureBox3.Visible = False
        PictureBox31.Visible = False
        PictureBox32.Visible = False
        Button33.Visible = False
        Label31.Visible = False
        Label32.Visible = False

        PictureBox0.Visible = True
        Button01.Visible = True
        Button02.Visible = True
        Button03.Visible = True

        If key6 = 0 Then
            Button02.Enabled = True
            key6 = key6 + 1
        End If
    End Sub


    '--------------------------------------------------------------------------------------------------------------------------
    '所有座位号按钮的代码      √
    Private Sub ButtonA1_Click(sender As Object, e As EventArgs) Handles ButtonA1.Click
        ButtonA1.Enabled = False
        Arr1(0) = 0
    End Sub
    Private Sub ButtonA2_Click(sender As Object, e As EventArgs) Handles ButtonA2.Click
        ButtonA2.Enabled = False
        Arr1(1) = 0
    End Sub
    Private Sub ButtonA3_Click(sender As Object, e As EventArgs) Handles ButtonA3.Click
        ButtonA3.Enabled = False
        Arr1(2) = 0
    End Sub
    Private Sub ButtonA4_Click(sender As Object, e As EventArgs) Handles ButtonA4.Click
        ButtonA4.Enabled = False
        Arr1(3) = 0
    End Sub
    Private Sub ButtonA5_Click(sender As Object, e As EventArgs) Handles ButtonA5.Click
        ButtonA5.Enabled = False
        Arr1(4) = 0
    End Sub
    Private Sub ButtonA6_Click(sender As Object, e As EventArgs) Handles ButtonA6.Click
        ButtonA6.Enabled = False
        Arr1(5) = 0
    End Sub
    Private Sub ButtonA7_Click(sender As Object, e As EventArgs) Handles ButtonA7.Click
        ButtonA7.Enabled = False
        Arr1(6) = 0
    End Sub
    Private Sub ButtonA8_Click(sender As Object, e As EventArgs) Handles ButtonA8.Click
        ButtonA8.Enabled = False
        Arr1(7) = 0
    End Sub
    Private Sub ButtonA9_Click(sender As Object, e As EventArgs) Handles ButtonA9.Click
        ButtonA9.Enabled = False
        Arr1(8) = 0
    End Sub
    Private Sub ButtonB1_Click(sender As Object, e As EventArgs) Handles ButtonB1.Click
        ButtonB1.Enabled = False
        Arr1(9) = 0
    End Sub
    Private Sub ButtonB2_Click(sender As Object, e As EventArgs) Handles ButtonB2.Click
        ButtonB2.Enabled = False
        Arr1(10) = 0
    End Sub
    Private Sub ButtonB3_Click(sender As Object, e As EventArgs) Handles ButtonB3.Click
        ButtonB3.Enabled = False
        Arr1(11) = 0
    End Sub
    Private Sub ButtonB4_Click(sender As Object, e As EventArgs) Handles ButtonB4.Click
        ButtonB4.Enabled = False
        Arr1(12) = 0
    End Sub
    Private Sub ButtonB5_Click(sender As Object, e As EventArgs) Handles ButtonB5.Click
        ButtonB5.Enabled = False
        Arr1(13) = 0
    End Sub
    Private Sub ButtonB6_Click(sender As Object, e As EventArgs) Handles ButtonB6.Click
        ButtonB6.Enabled = False
        Arr1(14) = 0
    End Sub
    Private Sub ButtonB7_Click(sender As Object, e As EventArgs) Handles ButtonB7.Click
        ButtonB7.Enabled = False
        Arr1(15) = 0
    End Sub
    Private Sub ButtonB8_Click(sender As Object, e As EventArgs) Handles ButtonB8.Click
        ButtonB8.Enabled = False
        Arr1(16) = 0
    End Sub
    Private Sub ButtonB9_Click(sender As Object, e As EventArgs) Handles ButtonB9.Click
        ButtonB9.Enabled = False
        Arr1(17) = 0
    End Sub
    Private Sub ButtonC1_Click(sender As Object, e As EventArgs) Handles ButtonC1.Click
        ButtonC1.Enabled = False
        Arr1(18) = 0
    End Sub
    Private Sub ButtonC2_Click(sender As Object, e As EventArgs) Handles ButtonC2.Click
        ButtonC2.Enabled = False
        Arr1(19) = 0
    End Sub
    Private Sub ButtonC3_Click(sender As Object, e As EventArgs) Handles ButtonC3.Click
        ButtonC3.Enabled = False
        Arr1(20) = 0
    End Sub
    Private Sub ButtonC4_Click(sender As Object, e As EventArgs) Handles ButtonC4.Click
        ButtonC4.Enabled = False
        Arr1(21) = 0
    End Sub
    Private Sub ButtonC5_Click(sender As Object, e As EventArgs) Handles ButtonC5.Click
        ButtonC5.Enabled = False
        Arr1(22) = 0
    End Sub
    Private Sub ButtonC6_Click(sender As Object, e As EventArgs) Handles ButtonC6.Click
        ButtonC6.Enabled = False
        Arr1(23) = 0
    End Sub
    Private Sub ButtonC7_Click(sender As Object, e As EventArgs) Handles ButtonC7.Click
        ButtonC7.Enabled = False
        Arr1(24) = 0
    End Sub
    Private Sub ButtonC8_Click(sender As Object, e As EventArgs) Handles ButtonC8.Click
        ButtonC8.Enabled = False
        Arr1(25) = 0
    End Sub
    Private Sub ButtonC9_Click(sender As Object, e As EventArgs) Handles ButtonC9.Click
        ButtonC9.Enabled = False
        Arr1(26) = 0
    End Sub
    Private Sub ButtonD1_Click(sender As Object, e As EventArgs) Handles ButtonD1.Click
        ButtonD1.Enabled = False
        Arr1(27) = 0
    End Sub
    Private Sub ButtonD2_Click(sender As Object, e As EventArgs) Handles ButtonD2.Click
        ButtonD2.Enabled = False
        Arr1(28) = 0
    End Sub
    Private Sub ButtonD3_Click(sender As Object, e As EventArgs) Handles ButtonD3.Click
        ButtonD3.Enabled = False
        Arr1(29) = 0
    End Sub
    Private Sub ButtonD4_Click(sender As Object, e As EventArgs) Handles ButtonD4.Click
        ButtonD4.Enabled = False
        Arr1(30) = 0
    End Sub
    Private Sub ButtonD5_Click(sender As Object, e As EventArgs) Handles ButtonD5.Click
        ButtonD5.Enabled = False
        Arr1(31) = 0
    End Sub
    Private Sub ButtonD6_Click(sender As Object, e As EventArgs) Handles ButtonD6.Click
        ButtonD6.Enabled = False
        Arr1(32) = 0
    End Sub
    Private Sub ButtonD7_Click(sender As Object, e As EventArgs) Handles ButtonD7.Click
        ButtonD7.Enabled = False
        Arr1(33) = 0
    End Sub
    Private Sub ButtonD8_Click(sender As Object, e As EventArgs) Handles ButtonD8.Click
        ButtonD8.Enabled = False
        Arr1(34) = 0
    End Sub
    Private Sub ButtonD9_Click(sender As Object, e As EventArgs) Handles ButtonD9.Click
        ButtonD9.Enabled = False
        Arr1(35) = 0
    End Sub
    Private Sub ButtonE1_Click(sender As Object, e As EventArgs) Handles ButtonE1.Click
        ButtonE1.Enabled = False
        Arr1(36) = 0
    End Sub
    Private Sub ButtonE2_Click(sender As Object, e As EventArgs) Handles ButtonE2.Click
        ButtonE2.Enabled = False
        Arr1(37) = 0
    End Sub
    Private Sub ButtonE3_Click(sender As Object, e As EventArgs) Handles ButtonE3.Click
        ButtonE3.Enabled = False
        Arr1(38) = 0
    End Sub
    Private Sub ButtonE4_Click(sender As Object, e As EventArgs) Handles ButtonE4.Click
        ButtonE4.Enabled = False
        Arr1(39) = 0
    End Sub
    Private Sub ButtonE5_Click(sender As Object, e As EventArgs) Handles ButtonE5.Click
        ButtonE5.Enabled = False
        Arr1(40) = 0
    End Sub
    Private Sub ButtonE6_Click(sender As Object, e As EventArgs) Handles ButtonE6.Click
        ButtonE6.Enabled = False
        Arr1(41) = 0
    End Sub
    Private Sub ButtonE7_Click(sender As Object, e As EventArgs) Handles ButtonE7.Click
        ButtonE7.Enabled = False
        Arr1(42) = 0
    End Sub
    Private Sub ButtonE8_Click(sender As Object, e As EventArgs) Handles ButtonE8.Click
        ButtonE8.Enabled = False
        Arr1(43) = 0
    End Sub
    Private Sub ButtonE9_Click(sender As Object, e As EventArgs) Handles ButtonE9.Click
        ButtonE9.Enabled = False
        Arr1(44) = 0
    End Sub
    Private Sub ButtonF1_Click(sender As Object, e As EventArgs) Handles ButtonF1.Click
        ButtonF1.Enabled = False
        Arr1(45) = 0
    End Sub
    Private Sub ButtonF2_Click(sender As Object, e As EventArgs) Handles ButtonF2.Click
        ButtonF2.Enabled = False
        Arr1(46) = 0
    End Sub
    Private Sub ButtonF3_Click(sender As Object, e As EventArgs) Handles ButtonF3.Click
        ButtonF3.Enabled = False
        Arr1(47) = 0
    End Sub
    Private Sub ButtonF4_Click(sender As Object, e As EventArgs) Handles ButtonF4.Click
        ButtonF4.Enabled = False
        Arr1(48) = 0
    End Sub
    Private Sub ButtonF5_Click(sender As Object, e As EventArgs) Handles ButtonF5.Click
        ButtonF5.Enabled = False
        Arr1(49) = 0
    End Sub
    Private Sub ButtonF6_Click(sender As Object, e As EventArgs) Handles ButtonF6.Click
        ButtonF6.Enabled = False
        Arr1(50) = 0
    End Sub
    Private Sub ButtonF7_Click(sender As Object, e As EventArgs) Handles ButtonF7.Click
        ButtonF7.Enabled = False
        Arr1(51) = 0
    End Sub
    Private Sub ButtonF8_Click(sender As Object, e As EventArgs) Handles ButtonF8.Click
        ButtonF8.Enabled = False
        Arr1(52) = 0
    End Sub
    Private Sub ButtonF9_Click(sender As Object, e As EventArgs) Handles ButtonF9.Click
        ButtonF9.Enabled = False
        Arr1(53) = 0
    End Sub
    Private Sub ButtonG1_Click(sender As Object, e As EventArgs) Handles ButtonG1.Click
        ButtonG1.Enabled = False
        Arr1(54) = 0
    End Sub
    Private Sub ButtonG2_Click(sender As Object, e As EventArgs) Handles ButtonG2.Click
        ButtonG2.Enabled = False
        Arr1(55) = 0
    End Sub
    Private Sub ButtonG3_Click(sender As Object, e As EventArgs) Handles ButtonG3.Click
        ButtonG3.Enabled = False
        Arr1(56) = 0
    End Sub
    Private Sub ButtonG4_Click(sender As Object, e As EventArgs) Handles ButtonG4.Click
        ButtonG4.Enabled = False
        Arr1(57) = 0
    End Sub
    Private Sub ButtonG5_Click(sender As Object, e As EventArgs) Handles ButtonG5.Click
        ButtonG5.Enabled = False
        Arr1(58) = 0
    End Sub
    Private Sub ButtonG6_Click(sender As Object, e As EventArgs) Handles ButtonG6.Click
        ButtonG6.Enabled = False
        Arr1(59) = 0
    End Sub
    Private Sub ButtonG7_Click(sender As Object, e As EventArgs) Handles ButtonG7.Click
        ButtonG7.Enabled = False
        Arr1(60) = 0
    End Sub
    Private Sub ButtonG8_Click(sender As Object, e As EventArgs) Handles ButtonG8.Click
        ButtonG8.Enabled = False
        Arr1(61) = 0
    End Sub
    Private Sub ButtonG9_Click(sender As Object, e As EventArgs) Handles ButtonG9.Click
        ButtonG9.Enabled = False
        Arr1(62) = 0
    End Sub
    Private Sub ButtonH1_Click(sender As Object, e As EventArgs) Handles ButtonH1.Click
        ButtonH1.Enabled = False
        Arr1(63) = 0
    End Sub
    Private Sub ButtonH2_Click(sender As Object, e As EventArgs) Handles ButtonH2.Click
        ButtonH2.Enabled = False
        Arr1(64) = 0
    End Sub
    Private Sub ButtonH3_Click(sender As Object, e As EventArgs) Handles ButtonH3.Click
        ButtonH3.Enabled = False
        Arr1(65) = 0
    End Sub
    Private Sub ButtonH4_Click(sender As Object, e As EventArgs) Handles ButtonH4.Click
        ButtonH4.Enabled = False
        Arr1(66) = 0
    End Sub
    Private Sub ButtonH5_Click(sender As Object, e As EventArgs) Handles ButtonH5.Click
        ButtonH5.Enabled = False
        Arr1(67) = 0
    End Sub
    Private Sub ButtonH6_Click(sender As Object, e As EventArgs) Handles ButtonH6.Click
        ButtonH6.Enabled = False
        Arr1(68) = 0
    End Sub
    Private Sub ButtonH7_Click(sender As Object, e As EventArgs) Handles ButtonH7.Click
        ButtonH7.Enabled = False
        Arr1(69) = 0
    End Sub
    Private Sub ButtonH8_Click(sender As Object, e As EventArgs) Handles ButtonH8.Click
        ButtonH8.Enabled = False
        Arr1(70) = 0
    End Sub
    Private Sub ButtonH9_Click(sender As Object, e As EventArgs) Handles ButtonH9.Click
        ButtonH9.Enabled = False
        Arr1(71) = 0
    End Sub
    Private Sub ButtonI1_Click(sender As Object, e As EventArgs) Handles ButtonI1.Click
        ButtonI1.Enabled = False
        Arr1(72) = 0
    End Sub
    Private Sub ButtonI2_Click(sender As Object, e As EventArgs) Handles ButtonI2.Click
        ButtonI2.Enabled = False
        Arr1(73) = 0
    End Sub
    Private Sub ButtonI3_Click(sender As Object, e As EventArgs) Handles ButtonI3.Click
        ButtonI3.Enabled = False
        Arr1(74) = 0
    End Sub
    Private Sub ButtonI4_Click(sender As Object, e As EventArgs) Handles ButtonI4.Click
        ButtonI4.Enabled = False
        Arr1(75) = 0
    End Sub
    Private Sub ButtonI5_Click(sender As Object, e As EventArgs) Handles ButtonI5.Click
        ButtonI5.Enabled = False
        Arr1(76) = 0
    End Sub
    Private Sub ButtonI6_Click(sender As Object, e As EventArgs) Handles ButtonI6.Click
        ButtonI6.Enabled = False
        Arr1(77) = 0
    End Sub
    Private Sub ButtonI7_Click(sender As Object, e As EventArgs) Handles ButtonI7.Click
        ButtonI7.Enabled = False
        Arr1(78) = 0
    End Sub
    Private Sub ButtonI8_Click(sender As Object, e As EventArgs) Handles ButtonI8.Click
        ButtonI8.Enabled = False
        Arr1(79) = 0
    End Sub
    Private Sub ButtonI9_Click(sender As Object, e As EventArgs) Handles ButtonI9.Click
        ButtonI9.Enabled = False
        Arr1(80) = 0
    End Sub


 
End Class
