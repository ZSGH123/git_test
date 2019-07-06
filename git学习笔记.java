git学习笔记：
一：git的最小配置
    1.配置user.name和user.email（why？）
	  git config --global user.name 'zkong'
	  git config --global user.email '2671242147@qq.com'
	2.config的三个作用域
	  git config --local 对某个仓库有效 （缺省值，优先级最高）
	  git config --global 对当前用户的所有仓库有效
	  git config --system  对系统所有登录用户有效
	3.显示config的配置，加--list
	  git config --list --global
	4.文件的复制
	  mac:  cp D:/test/data.txt . 
	  win:   copy D:\test\data.txt . 
	  
二：初始化本地文件夹为git仓库
     1.git init：初始化当前文件目录为git仓库。
	 2.git init 指定目录 ：初始化指定目录为git仓库。
	 
	 3.git add 文件名 ：把指定文件加入到暂存区。
	   git add . :把所有文件加入到暂存区。
     
	 4.git commit -m '提交内容' :把暂存区内容加入到git仓库
三：撤销文件和版本的回退
    1.撤销工作区内容：
	  git checkout -- file 可以丢弃工作区的修改
	2.撤销暂存区内容到工作区：
	  git reset HEAD <file> 可以把暂存区的修改撤销掉（unstage），重新放回工作区
	3.版本回退
	  Git允许我们在版本的历史之间穿梭，使用命令git reset --hard commit_id 或 git reset --hard HEAD~100
四：git分支的使用
    1.查看分支的合并情况：
    git log --graph --pretty=oneline --abbrev-commit
    2.查看仓库状态
	  git status
	3.可以把本地未push的分叉提交历史整理成直线；
	   git rebase
	4查看本地分支
	  git branch -a 全部
	  git branch -r 远程分支
    5.创建分支
	 git branch <name>
    6.切换分支
	 git checkout <name>
    7.创建+切换分支
	 git checkout -b <name>
    8.合并某分支到当前分支
	 git merge <name>
    9.删除分支
	 git branch -d <name> 
	10.删除远程分支
	 git branch -r -d origin/<branch-name>  
	 git push origin:branch-name
	11.查看远程分支
	 git remote
	 git remote -v
	12.拉取远程分支到本地
	git pull origin [远程branch-name]:[本地 branch-name]
	12.拉取远程分支到本地，并同时切换分支
	git checkout -b [本地 branch-name] :origin/[远程branch-name]
	13.推送本地分支到远程服务器
	git push origin [本地 branch-name]:[远程branch-name]
	
五：git stash命令的使用	 
    1.背景：并不是你不想提交，而是工作只进行到一半，还没法提交，预计完成还需1天时间。但是，必须在两个小时内修复该bug，
	怎么办？幸好，Git还提供了一个stash功能，可以把当前工作现场“储藏”起来，等以后恢复现场后继续工作
	2.使用：git stash后 现在，用git status查看工作区，就是干净的（除非有没有被Git管理的文件）
	3.工作区是干净的，刚才的工作现场存到哪去了？用git stash list命令看看
	4.工作现场还在，Git把stash内容存在某个地方了，但是需要恢复一下，有两个办法：
      一：git stash apply恢复，但是恢复后，stash内容并不删除，你需要用git stash drop来删除
      二：另一种方式是用git stash pop，恢复的同时把stash内容也删了
	  
六：git的tag命令使用
    1.git tag <name>就可以打一个新标签
	2.查看所有标签：git tag
	3.默认标签是打在最新提交的commit上的。有时候，如果忘了打标签，比如，现在已经是周五了，
	  但应该在周一打的标签没有打，怎么办？
	 方法：找到历史提交的commit id，然后打上就可以了：git  tag v0.9 commit id。
	4.创建带有说明的标签，用-a指定标签名，-m指定说明文字。
	  git tag -a v0.1 -m "version 0.1 released push url" d5a65e9
	5.用命令git show <tagname>可以看到说明文字。
    6.把本地仓库分支tag推送到远程服务器
	   1.push单个tag，命令格式为：
         git push origin [tagname]
       2.push所有tag，命令格式为：
         git push --tags 或 git push origin --tags
	   3删除tag
	     git tag -d tagname
		 
七：删除无用的远程文件
    git rm -r --cached .idea/* （--cached 表示本地仍旧保留）
    git rm -r --cached mskz-*/target/*
八：删除当前分支未跟踪的本地文件
    git clean -f
九：查看远程仓库信息
    git remote show [remote-name]
十 ：添加远程仓库
    要添加一个新的远程仓库，可以指定一个简单的名字，以便将来引用，运行 git remote add [shortname] [url]：
十一：远程仓库抓取数据
    git fetch [remote-name]
十二：远程仓库的删除和重命名
    1.git remote rename 命令修改某个远程仓库在本地的简称，比如想把 pb 改成 paul，可以这么运行：git remote rename pb paul
	  注意，对远程仓库的重命名，也会使对应的分支名称发生变化，原来的 pb/master 分支现在成了 paul/master。

    2.碰到远端仓库服务器迁移，或者原来的克隆镜像不再使用，又或者某个参与者不再贡献代码，那么需要移除对应的远端仓库，可以运行 git remote rm 命令：
       $ git remote rm paul
       $ git remote
       origin
十三：git cherry命令查看提交的分支的不同，也就是说你可以git cherry origin/master 查看，显示在当前分支origin/master下提交的状态
