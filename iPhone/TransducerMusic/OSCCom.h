//
//  OSCCom.h
//  TransducerMusic
//
//  Created by Govinda Ram Pingali on 11/13/13.
//  Copyright (c) 2013 GTCMT. All rights reserved.
//

#import <Foundation/Foundation.h>
#import <VVOSC/VVOSC.h>

@interface OSCCom : NSObject
{
    OSCManager *oscManager;
    OSCOutPort *oscOutport;
    OSCMessage *oscMessage;
}

- (void) initialize : (NSString*) hostIPAddress : (int) port;

- (void) sendFloat : (NSString*) address : (double*) floatValue : (int) size;

- (void) sendToggle : (NSString*) address : (bool) toggle;

- (void) sendBang : (NSString*) address;

- (void) updateHostAddress : (NSString*) ipAddress : (int) portNumber;


@end
