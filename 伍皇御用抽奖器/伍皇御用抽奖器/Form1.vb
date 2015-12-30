Public Class Form1

    Dim i As Integer = 1
    Dim j As Integer = 0
    Dim Students() As String, n As Integer = 0

    'i为不断变化的随机数 j为背景参数  n为总人数 students（）为字符数组存名字

    Public Sub Button1_Click(sender As Object, e As EventArgs) Handles Button1.Click  '开始按钮
        Button1.Visible = False
        Button2.Visible = False
        Button3.Visible = False
        PictureBox1.Visible = False

        Label11.Visible = True      '显示名字的框框
        Button11.Visible = True
        Button12.Visible = True
        Button13.Visible = True     '返回键
        PictureBox21.Visible = True   '大背景
        PictureBox22.Visible = True   '上面的文字
    End Sub

    Public Sub Button2_Click(sender As Object, e As EventArgs) Handles Button2.Click '设置按钮
        Button1.Visible = False
        Button2.Visible = False
        Button3.Visible = False
        PictureBox1.Visible = False

        Button21.Visible = True
        Button24.Visible = True       '返回键
        PictureBox3.Visible = True
    End Sub

    Public Sub Button3_Click(sender As Object, e As EventArgs) Handles Button3.Click  '关于按钮
        Button1.Visible = False
        Button2.Visible = False
        Button3.Visible = False
        PictureBox1.Visible = False

        Label31.Visible = True
        Button31.Visible = True     '返回键
        PictureBox4.Visible = True
    End Sub

    Public Sub Button13_Click(sender As Object, e As EventArgs) Handles Button13.Click  '返回键
        Button1.Visible = True
        Button2.Visible = True
        Button3.Visible = True
        PictureBox1.Visible = True

        Label11.Visible = False
        Button11.Visible = False
        Button12.Visible = False
        Button13.Visible = False
        PictureBox21.Visible = False
        PictureBox22.Visible = False
        PictureBox23.Visible = False
        PictureBox24.Visible = False
        PictureBox25.Visible = False
        PictureBox26.Visible = False
        PictureBox27.Visible = False
        PictureBox28.Visible = False
        PictureBox29.Visible = False
        PictureBox2x.Visible = False

    End Sub

    Public Sub Button24_Click(sender As Object, e As EventArgs) Handles Button24.Click  '返回键
        Button1.Visible = True
        Button2.Visible = True
        Button3.Visible = True
        PictureBox1.Visible = True

        Button21.Visible = False
        Button24.Visible = False  '返回键
        PictureBox3.Visible = False
    End Sub

    Public Sub Button31_Click(sender As Object, e As EventArgs) Handles Button31.Click  '返回键
        Button1.Visible = True
        Button2.Visible = True
        Button3.Visible = True
        PictureBox1.Visible = True

        Label31.Visible = False
        Button31.Visible = False   '返回键
        PictureBox4.Visible = False
    End Sub
    Public Sub Button21_Click(sender As Object, e As EventArgs) Handles Button21.Click
        Dim FireName As String

        If OpenFileDialog1.ShowDialog() = DialogResult.OK Then
            Dim sr As New System.IO.StreamReader(OpenFileDialog1.FileName)
            FireName = OpenFileDialog1.FileName
            sr.Close()
        End If
        '取得txt文件地址
        Dim txt As IO.StreamReader = New IO.StreamReader(FireName, System.Text.Encoding.Default)

        Do Until txt.EndOfStream
            n = n + 1
            ReDim Preserve Students(n) '数组从1开始
            Students(n) = txt.ReadLine()
        Loop

        txt.Close()
        Button1.Enabled = True
        Timer1.Enabled = True
        Button21.Text = "读取完成啦！"
        Button21.Enabled = False
        '将此文件的名字赋到数组Students（）
    End Sub
    Public Sub Button11_Click(sender As Object, e As EventArgs) Handles Button11.Click '继续键
        Timer1.Enabled = True

        If i = 29 Or i = 31 Or i = 38 Or i = 42 Or i = 46 Or i = 49 Or i = 54 Or i = 55 Or i = 64 Or i = 69 Then
            PictureBox23.Visible = False
            PictureBox27.Visible = True
        End If

        If i = 0 Or i = 1 Or i = 4 Or i = 10 Or i = 13 Or i = 17 Or i = 23 Or i = 24 Or i = 34 Or i = 36 Or i = 39 Or i = 40 Or i = 43 Or i = 47 Or i = 50 Or i = 51 Or i = 60 Or i = 63 Or i = 65 Then
            PictureBox25.Visible = False
            PictureBox27.Visible = True
        End If

        If i = 3 Or i = 5 Or i = 6 Or i = 8 Or i = 14 Or i = 21 Or i = 22 Or i = 28 Or i = 32 Or i = 33 Or i = 44 Then
            PictureBox26.Visible = False
            PictureBox27.Visible = True
        End If

        If i = 48 Or i = 52 Or i = 57 Or i = 59 Or i = 61 Or i = 62 Or i = 68 Or i = 76 Or i = 77 Or i = 78 Or i = 80 Or i = 81 Then
            PictureBox24.Visible = False
            PictureBox27.Visible = True
        End If

        If i = 2 Or i = 27 Or i = 41 Or i = 56 Or i = 67 Or i = 9 Or i = 11 Or i = 15 Or i = 72 Or i = 73 Or i = 79 Then
            PictureBox28.Visible = False
            PictureBox27.Visible = True
        End If

        If i = 12 Or i = 35 Or i = 45 Or i = 58 Or i = 7 Or i = 16 Or i = 18 Or i = 20 Or i = 25 Or i = 26 Then
            PictureBox2x.Visible = False
            PictureBox27.Visible = True
        End If

        If i = 19 Or i = 30 Or i = 37 Or i = 53 Or i = 66 Or i = 70 Or i = 71 Or i = 74 Or i = 75 Or i > 81 Then
            PictureBox29.Visible = False
            PictureBox27.Visible = True
        End If
    End Sub
    Public Sub Button12_Click(sender As Object, e As EventArgs) Handles Button12.Click '暂停键
        Timer1.Enabled = False
        PictureBox22.Visible = False
        If i = 29 Or i = 31 Or i = 38 Or i = 42 Or i = 46 Or i = 49 Or i = 54 Or i = 55 Or i = 64 Or i = 69 Then
            PictureBox27.Visible = False
            PictureBox23.Visible = True

        End If

        If i = 0 Or i = 1 Or i = 4 Or i = 10 Or i = 13 Or i = 17 Or i = 23 Or i = 24 Or i = 34 Or i = 36 Or i = 39 Or i = 40 Or i = 43 Or i = 47 Or i = 50 Or i = 51 Or i = 60 Or i = 63 Or i = 65 Then
            PictureBox27.Visible = False
            PictureBox25.Visible = True
        End If

        If i = 3 Or i = 5 Or i = 6 Or i = 8 Or i = 14 Or i = 21 Or i = 22 Or i = 28 Or i = 32 Or i = 33 Or i = 44 Then
            PictureBox27.Visible = False
            PictureBox26.Visible = True
        End If

        If i = 48 Or i = 52 Or i = 57 Or i = 59 Or i = 61 Or i = 62 Or i = 68 Or i = 76 Or i = 77 Or i = 78 Or i = 80 Or i = 81 Then
            PictureBox27.Visible = False
            PictureBox24.Visible = True
        End If

        If i = 2 Or i = 27 Or i = 41 Or i = 56 Or i = 67 Or i = 9 Or i = 11 Or i = 15 Or i = 72 Or i = 73 Or i = 79 Then
            PictureBox27.Visible = False
            PictureBox28.Visible = True
        End If

        If i = 12 Or i = 35 Or i = 45 Or i = 58 Or i = 7 Or i = 16 Or i = 18 Or i = 20 Or i = 25 Or i = 26 Then
            PictureBox27.Visible = False
            PictureBox2x.Visible = True
        End If

        If i = 19 Or i = 30 Or i = 37 Or i = 53 Or i = 66 Or i = 70 Or i = 71 Or i = 74 Or i = 75 Or i > 81 Then
            PictureBox27.Visible = False
            PictureBox29.Visible = True
        End If
    End Sub
    Public Sub Timer1_Tick(sender As Object, e As EventArgs) Handles Timer1.Tick   '延时器的工作
        '此时i=0 n=总人数 
        Label11.Text = Students(i)
        i = i + 1

        If i > n Then
            i = 1
        End If
    End Sub

End Class
