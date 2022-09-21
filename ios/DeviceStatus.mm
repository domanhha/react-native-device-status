#import "DeviceStatus.h"
#import <Security/Security.h>
#import <LocalAuthentication/LAContext.h>

#ifdef RCT_NEW_ARCH_ENABLED
#import "RNDeviceStatusSpec.h"
#endif

@implementation DeviceStatus
RCT_EXPORT_MODULE()

// Example method
// See // https://reactnative.dev/docs/native-modules-ios
RCT_EXPORT_METHOD(isDeviceSecure:(RCTPromiseResolveBlock)resolve
                  rejecter:(RCTPromiseRejectBlock)reject)
{

  NSError *aerr = nil;
  BOOL canBeProtected = [[LAContext new] canEvaluatePolicy:LAPolicyDeviceOwnerAuthentication error:&aerr];

  if (aerr || !canBeProtected) {
    return resolve(@(NO));
  } else {
    return resolve(@(YES));
  }
}

// Don't compile this code when we build for the old architecture.
#ifdef RCT_NEW_ARCH_ENABLED
- (std::shared_ptr<facebook::react::TurboModule>)getTurboModule:
    (const facebook::react::ObjCTurboModule::InitParams &)params
{
    return std::make_shared<facebook::react::NativeDeviceStatusSpecJSI>(params);
}
#endif

@end
