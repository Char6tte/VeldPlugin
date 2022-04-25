#!/bin/bash
# outputディレクトリ内のファイルをrsync over SSHで転送
rsync -acvz --delete ./build/libs/ user@remote:/path/to/deploy/
# サービスを再起動
ssh user@remote "<run restart or graceful-reload command>"