#!/bin/bash
# outputディレクトリ内のファイルをrsync over SSHで転送
rsync -acvz --delete ./build/libs/VeldPlugin-0.1-all.jar webuser@charlotte04.com:/opt/PluginServer/plugins/
# サービスを再起動
ssh webuser@charlotte04.com ""