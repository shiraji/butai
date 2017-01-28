#!/bin/bash

set -e

if [ "$TRAVIS_PULL_REQUEST" != "false" ]; then
  # Check how to run this script
  echo "It's pull request!"
else
  # add Github ssh setting
  openssl aes-256-cbc -K $encrypted_f3b4bfd8c9dc_key -iv $encrypted_f3b4bfd8c9dc_iv -in travis.enc -out .travis.ssh -d
  chmod 600 .travis.ssh
  echo -e "Host github.com\n\tStrictHostKeyChecking no\nIdentityFile .travis.ssh\n" >> ~/.ssh/config
fi
