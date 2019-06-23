git学习笔记：
一：git的最小配置
    1.配置user.name和user.email（why？）
	  git config --global user.name 'zkong'
	  git config --global user.email '2671242147@qq.com'
	2.config的三个作用域
	  git config --local 对某个仓库有效 （缺省）
	  git config --global 对当前用户的所有仓库有效
	  git config --system  对系统所有登录用户有效
	3.显示config的配置，加--list
	  git config --list --global
	4.文件的复制
	  mac:  cp D:/test/data.txt . 
	  win:   copy D:\test\data.txt . 
	  
二：初始化本地文件夹为git仓库
    