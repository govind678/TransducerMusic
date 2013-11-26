//
//  OSCCom.m
//  TransducerMusic
//
//  Created by Govinda Ram Pingali on 11/13/13.
//  Copyright (c) 2013 GTCMT. All rights reserved.
//

#import "OSCCom.h"

@implementation OSCCom

- (void) initialize : (NSString*) hostIPAddress : (int) port
{
    oscManager = [[OSCManager alloc] init];
    [oscManager setDelegate:self];
    
    oscOutport = [oscManager createNewOutputToAddress:hostIPAddress atPort:port];
}


- (void) sendFloat : (NSString*) address : (double*) floatValue : (int) size
{
    oscMessage = [OSCMessage createWithAddress:address];
    for (int i=0; i<size; i++) {
        [oscMessage addFloat:floatValue[i]];
    }
    [oscOutport sendThisMessage:oscMessage];
}


- (void) sendToggle : (NSString*) address : (bool) toggle
{
    oscMessage = [OSCMessage createWithAddress:address];
    [oscMessage addBOOL:toggle];
    [oscOutport sendThisMessage:oscMessage];
    
}


- (void) sendBang : (NSString*) address
{
    oscMessage = [OSCMessage createWithAddress:address];
    [oscMessage addBOOL:true];
    [oscOutport sendThisMessage:oscMessage];
}



- (void) updateHostAddress : (NSString*) ipAddress : (int) portNumber
{
    oscOutport = [oscManager createNewOutputToAddress:ipAddress atPort:portNumber];
}



@end
