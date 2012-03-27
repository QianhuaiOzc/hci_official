git clone ssh://git@172.26.14.102:222/home/git/repos/hci_official.git
git remote add hcidev ssh://git@172.26.14.102:222/home/git/repos/hci_official.git
git fetch hcidev

在提交修改的时候,把与本地IDE相关的文件乎略,千万不要提交那些文件.比较方便的乎略方式:
在项目目录下的.git/info/exclude文件中,添加你本地需要乎略的文件,然后在git status就不会提示修改,就可以乎略此更新.
