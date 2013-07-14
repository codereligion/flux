# ![Grappling hook](http://images.wikia.com/ztreasureisle/images/f/f7/NinjaGear_Grappling_Hook-icon.png) Git Hooks Dispatcher



## Quickstart
Clone the repository as a subtree in your existing repository:

    git subtree add --prefix git-hooks-dispatcher git@github.com:whiskeysierra/git-hooks-dispatcher.git
    
Install the dispatcher

    git-hooks-dispatcher/manage install

Your output should look something like this:

    $ git-hooks-dispatcher/manage install
    Linking dispatcher to ../.git/hooks/applypatch-msg [done]
    Linking dispatcher to ../.git/hooks/pre-applypatch [done]
    Linking dispatcher to ../.git/hooks/post-applypatch [done]
    Linking dispatcher to ../.git/hooks/pre-commit [done]
    Linking dispatcher to ../.git/hooks/prepare-commit-msg [done]
    Linking dispatcher to ../.git/hooks/commit-msg [done]
    Linking dispatcher to ../.git/hooks/post-commit [done]
    Linking dispatcher to ../.git/hooks/pre-rebase [done]
    Linking dispatcher to ../.git/hooks/post-checkout [done]
    Linking dispatcher to ../.git/hooks/post-merge [done]
    Linking dispatcher to ../.git/hooks/pre-receive [done]
    Linking dispatcher to ../.git/hooks/update [done]
    Linking dispatcher to ../.git/hooks/post-receive [done]
    Linking dispatcher to ../.git/hooks/post-update [done]
    Linking dispatcher to ../.git/hooks/pre-auto-gc [done]
    Linking dispatcher to ../.git/hooks/post-rewrite [done]

If you want to pull the latest changes to the dispatcher, run:

    git subtree pull --prefix git-hooks-dispatcher git@github.com:whiskeysierra/git-hooks-dispatcher.git

Feel free to add a handy git alias for the last command to your `.git/config` or `~/.gitconfig` if you
find the command to noisy. I sure do ;)

## Attributions
A good tutorial on the `git subtree` command can be found 
[here](http://blogs.atlassian.com/2013/05/alternatives-to-git-submodule-git-subtree/).

