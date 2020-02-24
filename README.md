## What is Paging Jetback ?
- it is an Library from Google , it made for controlling the getting and rendering Items in Recyclerview , if you did not undestand the purpose of Paging , just follow this Senario .
- >Morse Developer is a new developer in  Android Field and he was a dummy one , he used Rx with Retrofit to get 250 Object or more from Server to display them in RecyclerView , okay ?
>> Question 1 : What will the time be ?
okay , we can say if the Inflate and bind data to view will take an only 1 Seconds , So Recyclerview will took 250 seconds for finishing 2 process .
Question 2 : Is all users that downloading your app , will see all 250 Item when you request them ?
The answer >> I think it will be 90% users will not see all 250 Element

- > A Guy tell him , what if we load only 10 Items First then Show them So it will take 10 Seconds , then Check if the user scroll down for More Items , Paging Library will get 10 items morse and show them , then the user find what he want , then he Clicked on it .
>> Question 3 : Do you see any Advantage ?
I think you got it , you saved  230 Seconds for rendering the Items in Screen , Suppose the size of items is 1000 or 100000 , 10000000 , 100000000000000000

## Advantage 
		 Minmize the Time for Rendering Elements .
		 you can use it with another Jetback Components very easy .

## Component of Paging :-
+ we have from 4 to 7 Component :-
  *  PageList
  * PagedList.Config
  * PageAdapter
  * LivePagedListBuilder 
  * DataSource 
  * DataSource.Factory
  * DiffUtil
