# Read it if you are a DEV and if you need to change or extend the anything.

The only constant we have in this tech world is: **everything changes**, so if you need to chage anything please follow the topics

#### New Command
Add a new enum item at:[CommandActionType](src/main/java/com/oracle/construction/aconex/simulation/domain/simulation/command/CommandActionType.java)
it will be shown in the command list.

#### Change Command Behaviour
Change the same enum, just add or remove CommandActions: [CommandActionType](src/main/java/com/oracle/construction/aconex/simulation/domain/simulation/command/CommandActionType.java)

#### New Action
Implement a new [CommandAction](src/main/java/com/oracle/construction/aconex/simulation/domain/simulation/command/action/CommandAction.java)
and associate it with an command on enum [CommandActionType](src/main/java/com/oracle/construction/aconex/simulation/domain/simulation/command/CommandActionType.java)

#### Change Action Behaviour
Change and existent CommandAction located at: [CommandAction](src/main/java/com/oracle/construction/aconex/simulation/domain/simulation/command/action)
and associate if necessary to a command on enum [CommandActionType](src/main/java/com/oracle/construction/aconex/simulation/domain/simulation/command/CommandActionType.java)

#### New Cardinal capability
If you need to add NE, NW, SW, SE capabilities please add more items to enum:[CardinalDirection](src/main/java/com/oracle/construction/aconex/simulation/domain/simulation/map/CardinalDirection.java) 

#### New Item to track
Just add the item on enum: [Item](src/main/java/com/oracle/construction/aconex/simulation/domain/simulation/billing/Item.java)

#### Change Credit Values from Items
Just change the item on enum: [Item](src/main/java/com/oracle/construction/aconex/simulation/domain/simulation/billing/Item.java)

#### Add any Rule  
Just implement a new rule [CleaningRule](src/main/java/com/oracle/construction/aconex/simulation/domain/simulation/map/block/rules/CleaningRule.java)
and associate it with the constructor of any block type you want this rule to be executes.

#### Change Behaviour of any Rule  
Just change the rules at  [CleaningRule](src/main/java/com/oracle/construction/aconex/simulation/domain/simulation/map/block/rules)
and change the association at the constructor of the [Block](src/main/java/com/oracle/construction/aconex/simulation/domain/simulation/map/block/Block.java) type you want.

#### Add new block type
Just implement a new block [Block](src/main/java/com/oracle/construction/aconex/simulation/domain/simulation/map/block/Block.java)
and add a new Map item in the [BlockFactory](src/main/java/com/oracle/construction/aconex/simulation/domain/simulation/map/block/BlockFactory.java)

#### Change new block type
Just change the constructor of any block you want and change the [CleaningRule](src/main/java/com/oracle/construction/aconex/simulation/domain/simulation/map/block/rules) associated with the   [Block](src/main/java/com/oracle/construction/aconex/simulation/domain/simulation/map/block/Block.java)
